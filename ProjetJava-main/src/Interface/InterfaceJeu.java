package Interface;
import Representation.* ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.* ;


public class InterfaceJeu {
	
	private static JFrame fenetre = new JFrame();
	private static JMenuBar barreMenu = new JMenuBar() ;


	
	public InterfaceJeu() {
		
		configFenetre();
	}

    public static JFrame getFenetre() {
	    return fenetre;
    }

    public static void setFenetre(JFrame fenetre) {
	    InterfaceJeu.fenetre = fenetre;
    }


    public static JMenuBar getBarreMenu() {
	    return barreMenu;
    }


    public static void setBarreMenu(JMenuBar barreMenu) {
	    InterfaceJeu.barreMenu = barreMenu;
    }


    public static void cleanFenetre() {
	    getFenetre().getContentPane().removeAll();
	    getFenetre().revalidate() ;
	    getFenetre().repaint();
    }

    public static void menu(JButton chooseButton){
     JLayeredPane layeredPane = new JLayeredPane();
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


    public static void configFenetre() {

        getFenetre().setSize(1000, 1000); //taille fenetre
        getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
        getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
        configMenu() ;
        getFenetre().setVisible(true); // rendre la fenetre visible

    
    }

    public void afficherNodeBase(Node node) {
       JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 1000);
        //JPanel backgroundPanel = new JPanel(); // Panneau de fond pour couvrir la page entière
        //backgroundPanel.setBounds(0, 0, 1000,1000);
        //backgroundPanel.setBackground(Color.DARK_GRAY); // Couleur de fond
        //layeredPane.add(backgroundPanel, JLayeredPane.DEFAULT_LAYER);
        
        

	    fenetre.getContentPane().setLayout(null);
	    cleanFenetre() ;
        JPanel panelText= new JPanel();
        panelText.setBounds(60, 110, 600, 100);
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("", JLabel.CENTER);// affichage description Node 
        panelText.add(label); //ajout du label a la fenetre
        panelText.setBackground(Color.CYAN); 
        label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        getFenetre().revalidate();
        getFenetre().repaint();
        JButton btn = new JButton("TEST POPUP");
        panelText.add(btn);
        menu(btn);


	
        char[] texts = node.getDescription().toCharArray(); // transformation de la chaine descrition en tableau de char
        Timer timer = new Timer(20, new ActionListener() { // timer apparition d'un char composant le tableau ci-dessus toutes les 20milisec
        int index = 0; // index pour recuperer chaque char par l'intermediaire du tableau

        @Override
        public void actionPerformed(ActionEvent e) {
            if (index < texts.length) { //Parcours de la chaine Descrition caractère par caractère grace au tableau texts
                char nextChar = node.getDescription().charAt(index); // recuperation dans la chaine de caractere du caractere associé a l'index
                if(nextChar =='/'){ //creation d'une condition de passage a la ligne : utilisation de balise web (retour chariot ne marchant pas) MAIS A REVOIR 
                    label.setText(label.getText() + "<br>");
                    index++;
                
                }
                else{
                    label.setText(label.getText() + nextChar); // label.getText() récupère le texte actuellement affiche dans la frame. On ajoute le caractere suivant qui compose la chaine Descrition. ATTENTION setText() ne prend que des String(!=char)
                    index++; //on passe au caractere suivant de la chaine de description
                }
            
            } else {
                ((Timer) e.getSource()).stop(); // Arrête le timer après l'affichage de tous les textes

                if (node.getClass()== ChooseNode.class){ //Si le node en question est un chooseNode: affichage boutons choix
                    ChooseNodeButton(node);
                }
                if(node.getClass()== InnerNode.class){ // Si le node est un innerNode affichage boutonSuivant
                    InnerNodeButton(node);
                }
            
            }
        
        }
    });


    timer.start(); 

}
//Fonction creation de bouton chooseNode
    public void ChooseNodeButton(Node node){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 1000);
         getFenetre().add(layeredPane);
        ChooseNode chooseNode;
        chooseNode=(ChooseNode)node;
        JPanel panelChoose= new JPanel(); // Cration panel qui contient les boutons choose node
        panelChoose.setBounds(661, 109, 194, 323);
        layeredPane.add(panelChoose, JLayeredPane.POPUP_LAYER);
	    panelChoose.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
        panelChoose.setBackground(Color.RED); //couleur aleatoire ahah!
    
        for (int i = 0; i < chooseNode.getOptions().size(); i++) {
            final int currentIndex = i;
            JButton btn1 = new JButton(chooseNode.getOptions().get(i).getNom());
            btn1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
            btn1.setBackground(new Color(240, 240,240));
		    btn1.setForeground(new Color(128, 64, 0));
            panelChoose.add(btn1);
           btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chooseNode.getOptions().get(currentIndex).display(); // clique du bouton provoque affichage du prochain bode
                
                }
            });
            
        getFenetre().revalidate();
        }
    }

//Creation de bouton Suivant
    public void InnerNodeButton(Node node){
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 1000, 1000);
        JPanel panelInner = new JPanel();
         getFenetre().add(layeredPane);
		panelInner.setBounds(711, 494, 144, 62);
        
		layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
        panelInner.setBackground(Color.yellow);
        if(node.getClass()== InnerNode.class){
            JButton suivant = new JButton("Suivant"); // création button
                    suivant.setFont(new Font("Times New Roman", Font.PLAIN, 11));
                    suivant.setBackground(new Color(240, 240,240));
		            suivant.setForeground(new Color(128, 64, 0));
                    panelInner.add(suivant);
                    getFenetre().revalidate() ;
				    boutonGoNext(suivant, node);
        }
    }   


    public void boutonGoNext(JButton btn1, Node node){
        btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Code à exécuter lorsque le bouton est cliqué
                    	    node.goNext().display(); ;
                    	
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

