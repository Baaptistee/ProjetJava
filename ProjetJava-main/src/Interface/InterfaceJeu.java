/**
* Represents the game interface that displays nodes and allows interactions.
*/

package Interface;
import Representation.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Event.*;
import Event.ImageNode;

import javax.swing.* ;



public class InterfaceJeu {
	
	private static JFrame fenetre = new JFrame(); // Reference to the main frame of the game interface.
	private static JMenuBar barreMenu = new JMenuBar() ;//Reference to the menu bar of the game interface.
    private static JLayeredPane layeredPane =new JLayeredPane();


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

    public static JLayeredPane getLayeredPane(){
        return layeredPane;
    }

    public static void setLayeredPane(JLayeredPane layeredPane){
        InterfaceJeu.layeredPane=layeredPane;
    }

     /**
     * Clears the content of the game frame.
     */

    public static void cleanFenetre() {
	    getFenetre().getContentPane().removeAll();
	    getFenetre().revalidate() ;
	    getFenetre().repaint();
    }

     
public static void POPUP(JButton chooseButton){
     
        configPanel();
        JPanel panelPopUp = new JPanel();
        panelPopUp.setBounds(50, 50, 300, 200);
        panelPopUp.setBackground(Color.white);
        panelPopUp.setVisible(false);
        layeredPane.add(panelPopUp, JLayeredPane.DRAG_LAYER);
        getFenetre().add(layeredPane);
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelPopUp.isVisible()) {
                    panelPopUp.setVisible(false);
                } else {
                    panelPopUp.setVisible(true);
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
    public static void configPanel(){
        layeredPane.setBounds(0, 0, 1000, 1000);
    }

    /**
     * Displays a base node in the game interface.
     * @param node The node to be displayed.
     */

    
 public void afficherNodeBase(Node node, ImageIcon imageIcon) {

        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        afficherImageDansInterface(new ImageIcon(node.getImageName()));

	    getFenetre().getContentPane().setLayout(null);
	    cleanFenetre() ;
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        JEditorPane editorPane = new JEditorPane();
 
        if (node instanceof ChooseNode){ 
            panelText.setBounds(60, 110, 600, 300);
            editorPane.setPreferredSize(new Dimension(600, 300));
        }
        if (node instanceof TextNode || node instanceof ChanceNode ||node instanceof TestNode){ 
            panelText.setBounds(80, 110, 850, 300);
            editorPane.setPreferredSize(new Dimension(850, 300));
        }
         if (node instanceof TerminalNode){ 
            panelText.setBounds(80, 110, 800, 300);
            editorPane.setPreferredSize(new Dimension(800, 300));
        }
         if (node instanceof FightNode){ 
            panelText.setBounds(60, 110, 600, 100);
            editorPane.setPreferredSize(new Dimension(600, 100));
        }
        
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("<html>", JLabel.CENTER);// Create a label for displaying the description of the node
        panelText.add(label);
        panelText.setBackground(Color.CYAN); 
        label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        getFenetre().revalidate();
        getFenetre().repaint();
        // JButton btn = new JButton("TEST POPUP");
        // panelText.add(btn);
        // POPUP(btn);

        editorPane.setOpaque(false);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html"); // Set content type to HTML
        
        panelText.add(editorPane);
	
        char[] texts = node.getDescription().toCharArray(); // Convert the description text of the node to a character array
        Timer timer = new Timer(10, new ActionListener() { // Create a timer to display the description character by character
        int index = 0; // Index to retrieve each character from the description
        StringBuilder textBuilder = new StringBuilder();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { 
                char nextChar = texts[index];
                    if ((nextChar == '/') && !(texts[index - 1] == '<')) {
                        textBuilder.append("<br>");
                        editorPane.setText(textBuilder.toString());
                        index++;
                
                }
                else{
                    textBuilder.append(nextChar);
                    editorPane.setText(textBuilder.toString());
                    index++;
                }
            
            } else {
                ((Timer) e.getSource()).stop(); // Handle line breaks using HTML tag

                // Determine the type of the node and handle accordingly
                if ( node instanceof ChooseNode){ 
                    ChooseNodeButton(node, imageIcon);
                }
                if(node instanceof TextNode || node instanceof ChanceNode || node instanceof TestNode ){ 
                    InnerNodeButton(node);
                }
                if(node instanceof FightNode){
                    FightNodeButton(node);
                }
                if(node instanceof TerminalNode){
                    TerminalNodeButton(node);
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

    public void ChooseNodeButton(Node node, ImageIcon imageIcon){
        configPanel();
        ChooseNode chooseNode;// Cast the node to a ChooseNode
        
        chooseNode=(ChooseNode)node;

        JPanel panelChoose= new JPanel(); // Create a panel to hold the ChooseNode buttons
        getFenetre().add(layeredPane);
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
                    ImageNode imageNode= new ImageNode(chooseNode.getOptions().get(currentIndex), imageIcon);
                    imageNode.display();
                    System.out.println("first");
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
        configPanel();
      
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

        configPanel();
        
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
        
    }

   
    
    

    public void CloseFrame(){
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getFenetre().dispose(); // Fermer la fenêtre
            }
        });
        
        timer.setRepeats(false); // Pour ne déclencher l'événement qu'une seule fois
        timer.start(); // Démarrer le timer
    
    }

     public void TerminalNodeButton(Node node) {
        configPanel();
        JPanel panelTerminal = new JPanel();
        getFenetre().add(layeredPane);
        panelTerminal.setBounds(711, 494, 144, 62);
        layeredPane.add(panelTerminal, JLayeredPane.POPUP_LAYER);
        panelTerminal.setBackground(Color.YELLOW);
        this.CloseFrame();
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
                        	node.goNext() ; // Code to execute when the button is clicked
                            
                            
                        }
            });
    }

    public void afficherImageDansInterface(ImageIcon imageIcon) {
        if (imageIcon != null) {
            configPanel();
            JLabel label = new JLabel(imageIcon);
            JPanel panel = new JPanel();
            panel.add(label);
            panel.setOpaque(false);
            panel.setBounds(0, 0, 1280, 720);
            layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
            getFenetre().add(layeredPane);
            getFenetre().setVisible(true);
        }
    }
    


}

