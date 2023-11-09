/**
* Represents the game interface that displays nodes and allows interactions.
*/

package Interface;
import Representation.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.* ;



public class InterfaceJeu {
	
	private static JFrame fenetre = new JFrame(); // Reference to the main frame of the game interface.
	private static JMenuBar barreMenu = new JMenuBar() ;//Reference to the menu bar of the game interface.
    private static JLayeredPane layeredPane = new JLayeredPane();


	 /**
     * Constructs a new game interface and configures the frame.
     */

	public InterfaceJeu() {
		
		configFenetre();
	}

     /**
     * Get the main frame of the game interface.
     * @return The main frame.
     */

    public static JFrame getFenetre() {
	    return fenetre;
    }

     /**
     * Set the main frame of the game interface.
     * @param fenetre The main frame to set.
     */

    public static void setFenetre(JFrame fenetre) {
	    InterfaceJeu.fenetre = fenetre;
    }

     /**
     * Get the menu bar of the game interface.
     * @return The menu bar.
     */

    public static JMenuBar getBarreMenu() {
	    return barreMenu;
    }

     /**
     * Set the menu bar of the game interface.
     * @param barreMenu The menu bar to set.
     */
    public static void setBarreMenu(JMenuBar barreMenu) {
	    InterfaceJeu.barreMenu = barreMenu;
    }

     /**
     * Clears the content of the game frame.
     */

    public static void cleanFenetre() {
	    getFenetre().getContentPane().removeAll();
	    getFenetre().revalidate() ;
	    getFenetre().repaint();
    }

     
public static void menu(JButton chooseButton){
     
        layeredPane.setBounds(0, 0, 1000, 1000);
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 300, 200);
        panel.setBackground(Color.BLUE);
        panel.setVisible(false);
        layeredPane.add(panel, JLayeredPane.DRAG_LAYER);
        getFenetre().add(layeredPane);
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel.isVisible()) {
                    panel.setVisible(false);
                } else {
                    panel.setVisible(true);
                }
            }
        });
}

     /**
     * Configures the game menu including options for inventory, story, and status.
     */

    public static void configMenu() {
        JMenu inventaire = new JMenu("Inventaire");
        JMenu histoire = new JMenu("Histoire");
        JMenu statut = new JMenu("Statut");
    
        JMenuItem precedent = new JMenuItem("Voir précédent");
        JMenuItem resumeH = new JMenuItem("Résumé de l'histoire");
        JMenuItem stats = new JMenuItem("Statistiques");
    
        histoire.add(precedent);
        histoire.add(resumeH);
        statut.add(stats);
    
        getBarreMenu().add(histoire);
        getBarreMenu().add(inventaire);
        getBarreMenu().add(statut);
        getFenetre().setJMenuBar(getBarreMenu());
       
        
    }

     /**
     * Configures the game frame including its size, location, and visibility.
     */

    public static void configFenetre() {

        getFenetre().setSize(1000, 1000); //taille fenetre
        getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
        getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
        configMenu() ;
        getFenetre().setVisible(true); // rendre la fenetre visible

    
    }

    /**
     * Displays a base node in the game interface.
     * @param node The node to be displayed.
     */

    
 public void afficherNodeBase(Node node) {

        layeredPane.setBounds(0, 0, 1000, 1000);
        //JPanel backgroundPanel = new JPanel(); // Panneau de fond pour couvrir la page entière
        //backgroundPanel.setBounds(0, 0, 1000,1000);
        //backgroundPanel.setBackground(Color.DARK_GRAY); // Couleur de fond
        //layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        

	    fenetre.getContentPane().setLayout(null);
	    cleanFenetre() ;
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        if (node.getClass()== ChooseNode.class){ 
            panelText.setBounds(60, 110, 600, 100);
        }
        if (node.getClass()==  InnerNode.class){ 
            panelText.setBounds(80, 110, 800, 300);
        }
        
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
        panelText.add(label);
        panelText.setBackground(Color.CYAN); 
        label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        getFenetre().revalidate();
        getFenetre().repaint();
        JButton btn = new JButton("TEST POPUP");
        panelText.add(btn);
        menu(btn);


	
        char[] texts = node.getDescription().toCharArray(); // Convert the description text of the node to a character array
        Timer timer = new Timer(20, new ActionListener() { // Create a timer to display the description character by character
        int index = 0; // Index to retrieve each character from the description


        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { 
                char nextChar = node.getDescription().charAt(index); 
                if(nextChar =='/'){  
                    label.setText(label.getText() + "<br>");
                    index++;
                
                }
                else{
                    label.setText(label.getText() + nextChar); // label.getText() récupère le texte actuellement affiche dans la frame. On ajoute le caractere suivant qui compose la chaine Descrition. ATTENTION setText() ne prend que des String(!=char)
                    index++; //on passe au caractere suivant de la chaine de description
                }
            
            } else {
                ((Timer) e.getSource()).stop(); // Handle line breaks using HTML tag

                // Determine the type of the node and handle accordingly
                if (node.getClass()== ChooseNode.class){ 
                    ChooseNodeButton(node);
                }
                if(node.getClass()== InnerNode.class){ 
                    InnerNodeButton(node);
                }
                if(node.getClass()== FightNode.class){
                    FightNodeButton(node);
                }
            
            }
        
        }
    });


    timer.start(); 

}
    /**
    * Configures the interface to display buttons for a ChooseNode and handles the button actions.
    *
    * @param node The current ChooseNode to display options for.
    */

    public void ChooseNodeButton(Node node){

        JLayeredPane layeredPane = new JLayeredPane();// Create a layered pane to organize components
        layeredPane.setBounds(0, 0, 1000, 1000);
        getFenetre().add(layeredPane);

        ChooseNode chooseNode;// Cast the node to a ChooseNode
        chooseNode=(ChooseNode)node;

        JPanel panelChoose= new JPanel(); // Create a panel to hold the ChooseNode buttons
        panelChoose.setBounds(661, 109, 194, 323);
        layeredPane.add(panelChoose, JLayeredPane.POPUP_LAYER);
	    panelChoose.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        panelChoose.setBackground(Color.RED); 

        // Create buttons for each option in the ChooseNode
        for (int i = 0; i < chooseNode.getOptions().size(); i++) {
            final int currentIndex = i;
            JButton btn1 = new JButton(chooseNode.getOptions().get(i).getNom());
            btn1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
            btn1.setBackground(new Color(240, 240,240));
		    btn1.setForeground(new Color(128, 64, 0));
            panelChoose.add(btn1);

            // Add an ActionListener to handle button clicks
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chooseNode.getOptions().get(currentIndex).display(); // clique du bouton provoque affichage du prochain bode
                
                }
            });
            
        getFenetre().revalidate();
        }
    }

    /**
    * Configures the interface to display the "Next" button for an inner node (InnerNode).
    *
    * @param node The current inner node.
    */

    public void InnerNodeButton(Node node){

        // Create a layered pane to organize components
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 1000);

        // Create a panel for the "Next" button
        JPanel panelInner = new JPanel();
        getFenetre().add(layeredPane);
		panelInner.setBounds(711, 494, 144, 62);
        
        // Add the "Next" panel to the layered pane
		layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
        panelInner.setBackground(Color.yellow);
        
        
        JButton suivant = new JButton("Suivant"); // Create a "Next" button
        suivant.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        suivant.setBackground(new Color(240, 240,240));
		suivant.setForeground(new Color(128, 64, 0));
        panelInner.add(suivant);
        getFenetre().revalidate() ;
		boutonGoNext(suivant, node);
        
    }   

    /**
    * Configures the interface to display options for a fight node.
    *
    * @param node The current fight node.
    */

    public void FightNodeButton(Node node){

        JLayeredPane layeredPane = new JLayeredPane(); // Create a layered pane to organize components
        layeredPane.setBounds(0, 0, 1000, 1000);
        
        JPanel panelFight = new JPanel(); // Create the main panel to contain the options and validate button
        panelFight.setBounds(700, 200, 150, 300);
        layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);
        panelFight.setLayout(new FlowLayout());

        ButtonGroup buttonGroup = new ButtonGroup();  // Create a button group to handle radio button selection

        // Create and add radio buttons for different fight options
        for (int i = 1; i <= 5; i++) {
            JRadioButton radioButton = new JRadioButton("Option " + i);
            buttonGroup.add(radioButton);
            panelFight.add(radioButton);
        }


        JButton validateButton = new JButton("Valider");// Create and add a button to validate the selected option

        panelFight.add(validateButton);
        getFenetre().add(panelFight);
        getFenetre().setVisible(true);
        /*validateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = "Aucune option sélectionnée";
                if (radioButton1.isSelected()) {
                   
                } else if (radioButton2.isSelected()) {
                    
                } else if (radioButton3.isSelected()) {
                    
                }
                JOptionPane.showMessageDialog(getFenetre(), selectedOption);
            }
        });*/
    }

    public void CloseFame(Button btn){
         btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getFenetre().dispose();
                }
            });
    }

    /**
    * Configures a "Next" button to display the next node when clicked.
    *
    * @param btn1 The "Next" button to configure.
    * @param node The current node that will be followed by the next node when the button is clicked.
    */

    public void boutonGoNext(JButton btn1, Node node){
        btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                    	   // node.goNext().display(); // Code to execute when the button is clicked
                    	
                        }
            });
    }


}
/*JPanel z = new JPanel();
		        z.setBounds(56, 212, 552, 344);
		        fenetre.getContentPane().add(z);
		        z.setLayout(null);
		        JLayeredPane layeredPane = new JLayeredPane();
		        layeredPane.setBounds(89, 34, 320, 239);
		        layeredPane.setForeground(new Color(0, 255, 64));
		        layeredPane.setBorder(new MatteBorder(4, 3, 1, 6, (Color) new Color(0, 0, 0)));
                layeredPane.setBackground(Color.BLUE);
                j.setOpaque(false);
		        z.add(layeredPane);
		        layeredPane.setLayout(null);
		
		        JPanel panel_5 = new JPanel();
		        panel_5.setBounds(89, 36, 117, 168);
		        layeredPane.add(panel_5,JLayeredPane.DEFAULT_LAYER);
		        panel_5.setLayout(null);
		
		        JLabel lblNewLabel_1 = new JLabel("bienvenidos");
		        lblNewLabel_1.setBounds(10, 30, 73, 14);
		        panel_5.add(lblNewLabel_1);
		
		        JButton ok = new JButton("ok");
		        ok.setBounds(10, 110, 89, 23);
		        panel_5.add(ok);
                ok.addActionListener(new ActionListener() {
                    @Override
                public void actionPerformed(ActionEvent e) {
                layeredPane.setVisible(false);

                }
                });*/