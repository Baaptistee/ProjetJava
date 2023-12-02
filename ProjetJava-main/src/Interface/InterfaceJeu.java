/**
* Represents the game interface that displays nodes and allows interactions.
*/

package Interface;
import Representation.* ;
import univers.competences.CompetencesActives;
import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageAdversaire;
import univers.personnages.PersonnageCombattant;
import univers.* ;
import univers.competences.CompetenceDammage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

    
 public void afficherNodeBase(Node node) {

        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        
	    getFenetre().getContentPane().setLayout(null);
	    cleanFenetre() ;
        JPanel panelText= new JPanel();// Create a panel for the text content of the node
        if (node instanceof ChooseNode){ 
            panelText.setBounds(60, 110, 600, 100);
        }
        if (node instanceof TextNode || node instanceof ChanceNode ||node instanceof TestNode){ 
            panelText.setBounds(80, 110, 850, 300);
        }
         if (node instanceof TerminalNode){ 
            panelText.setBounds(80, 110, 800, 300);
        }
         if (node instanceof FightNode){ 
            panelText.setBounds(60, 110, 600, 100);
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
        POPUP(btn);


	
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
                if ( node instanceof ChooseNode){ 
                    ChooseNodeButton(node);
                }
                if(node instanceof TextNode || node instanceof ChanceNode || node instanceof TestNode ){ 
                    InnerNodeButton(node);
                }
                if(node instanceof FightNode){
                    playFightNode(node);
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

    public void ChooseNodeButton(Node node){
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

    public void playFightNode(Node node){
        FightNode node1 = (FightNode) node ;
        
        // on play un tour de fight node 
        playTourFightNode(node1) ;
        // cette fonction ne sera appelée que quand tous les tours seront finis 
        //clenode.goNext();
    }

    public void playTourFightNode(FightNode node) {
        Map<PersonnageCombattant, Object[]> actions = new HashMap<>();
    
        // on sélectionne les attaques des personnages du groupe contrôlé par le joueur 
        
        actions =  selectionAction(node, actions, 0);
       
        

       System.out.println("tatata") ; 
        // puis met les attaques sélectinées améatoirement des adversaires 
        
        //actions = selectionAdverse(node,actions1) ;
        
        // puis on exécute toutes ces actions 
        //faireActions(actions1) ;
        // si le combat n'est pas fini on relance un tour ! 
         
        if (node.isOver()==false) {
            playTourFightNode(node);
            
        } 
        System.out.println("tatata");
    }
    
    /* 
    public void faireActions(Map<PersonnageCombattant, Object[]> actions) {
        
        // on transforme la map d'action en une arraylist
        Set<PersonnageCombattant> a = actions.keySet();
        ArrayList<PersonnageCombattant> ordreDAction = new ArrayList<PersonnageCombattant>(a);
    // on trie la liste en fonction de la vitesse des personnages 
        Collections.sort(ordreDAction, Comparator.comparingInt(PersonnageCombattant::getSpeed));

        
        String texteAction ="" ;
        // le nombre d'action du tour 
        int nombreAction = ordreDAction.size() ;
        // iteration = à quelle action à afficher on en est 
        int iteration = ordreDAction.size() ;
        // boucle pou créer le texte avec toutes les actions 
        for (int i =0 ; i <ordreDAction.size();i++) {
            PersonnageCombattant utilisateur = ordreDAction.get(i) ;
            PersonnageCombattant cible = (PersonnageCombattant)actions.get(ordreDAction.get(i))[1] ;
            CompetencesActives competence = (CompetencesActives)actions.get(ordreDAction.get(i))[0] ;
            texteAction += (competence.utilisation(utilisateur, cible)) + "$"; // on va se servir du charactère dollar un peu de la même manière dont on s'est servi du charactère "/" 
            // PROPOSITION : on affiche toutes les 3 utilisations de compétences pour pas surcharger l'écran mais pas perdre torp de temps non plus
        }

        // puis on lance la fonction afficher action qui permet d'afficher les actions 
        afficherAction(texteAction, nombreAction, iteration);

        
    }

    public void afficherAction(String texteAction, int iteration, int nombreAction){  
        // on va faire décroitre le int itration donc quand c à zéro on stop
        if (iteration <= 0) {
            
            configPanel();
            layeredPane.removeAll();
            layeredPane.revalidate();
            layeredPane.repaint();

        
	        getFenetre().getContentPane().setLayout(null);
	        cleanFenetre() ;
            JPanel panelText= new JPanel();
        
            panelText.setBounds(80, 110, 850, 300);
            layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
            getFenetre().add(layeredPane);
            JLabel label = new JLabel("", JLabel.CENTER);// Create a label for displaying the description of the node
            panelText.add(label);
            panelText.setBackground(Color.CYAN); 
            label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
            getFenetre().revalidate();
            getFenetre().repaint();

            char[] texts = texteAction.toCharArray(); // Convert the description text of the node to a character array
            Timer timer = new Timer(20, new ActionListener() { // Create a timer to display the description character by character
            int index = 0; // Index to retrieve each character from the description


            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < texts.length) { 
                    char nextChar = texteAction.charAt(index); 
                    if(nextChar =='/'){  
                        label.setText(label.getText() + "<br>");
                        index++;
                
                    }
                    else{
                        label.setText(label.getText() + nextChar); // label.getText() récupère le texte actuellement affiche dans la frame. On ajoute le caractere suivant qui compose la chaine Descrition. ATTENTION setText() ne prend que des String(!=char)
                        index++; //on passe au caractere suivant de la chaine de description
                    }
            
                } else {
                    ((Timer) e.getSource()).stop(); // Handle line breaks using HTML ta
                     ButtonSuivant(texteAction, iteration, nombreAction);
                    
            
                }
        
            }
        });


    timer.start();           
            
        }
    }
    
     public void ButtonSuivant(String texteAction, int nombreAction, int iteration){
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
		    afficherprochaineaction(suivant, texteAction, nombreAction, iteration ) ;
     }

    public void afficherprochaineaction(JButton suivant, String texteAction, int nombreAction, int iteration) {
        int nextIteration = iteration - 3;
        suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            // on relance la fonction afficher action avec ce qui reste 
                            // A FAIRE : faire que la premiere iteration n'affiche que les 3 premieres, la seconde que les 3 suivantes etc. 
                            afficherAction(texteAction, nextIteration, nombreAction);
                        }
            });

    }


    public Map<PersonnageCombattant, Object[]> selectionAdverse(FightNode node, Map<PersonnageCombattant, Object[]> actions){
        // pour chaque opponent on lui attribue une action
        for (int i = 0; i<node.getOpponents().size();i++) {
            
            actions = ((PersonnageAdversaire)node.getOpponents().get(i)).selectionTout(actions) ;
        }
        return actions ;
    }

    */
    public Map<PersonnageCombattant, Object[]> selectionAction(FightNode node, Map<PersonnageCombattant, Object[]> actions, int perso) {
        
        if (perso<Game.getGroupeJoueurVivant().size()) {
        configPanel();
        
        JPanel panelFight = new JPanel(); // Create the main panel to contain the options and validate button
        panelFight.setBounds(700, 200, 150, 300);
        layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);
        panelFight.setLayout(new FlowLayout());
        panelFight.setBackground(Color.PINK);



        ButtonGroup buttonGroup = new ButtonGroup();  // Create a button group to handle radio button selection
            //int nextIteration = perso + 1 ;
            for (int j = 0; j < Game.getGroupeJoueurVivant().get(perso).getCompetences().size(); j++) {
                JRadioButton radioButton = new JRadioButton(Game.getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName());
                radioButton.setActionCommand(Game.getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName());
                buttonGroup.add(radioButton);
                panelFight.add(radioButton);             
            }
            JButton validateButton = new JButton("Valider");// Create and add a button to validate the selected option

            panelFight.add(validateButton);
            getFenetre().add(panelFight);
            getFenetre().setVisible(true);

            validateButton.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) { 
                       CompetencesActives c = null ;
                        String n = buttonGroup.getSelection().getActionCommand() ;
                        for (int i = 0 ; i<Game.getGroupeJoueur().get(perso).getCompetences().size();i++) {
                            if (Game.getGroupeJoueur().get(perso).getCompetences().get(i).getName()== n) {
                                c = Game.getGroupeJoueur().get(perso).getCompetences().get(i) ;
                            }
                        }

                        Object[] cibleCompetence = {c, null};
                        actions.put((PersoGroupe)Game.getGroupeJoueurVivant().get(perso), cibleCompetence) ;
                        if (c.isGroup()) {
                            //pas besoin de sélection de la cible pour les attaques de groupe
                            selectionAction(node, actions, perso);
                        } else {
                            selectionCible(node, actions, (PersoGroupe)Game.getGroupeJoueur().get(perso), perso) ;
                        }   
                    }
            });

            System.out.println("tototo");
            return actions ;
        } 
        else return actions ;

    }
    
    public void selectionCible(FightNode node, Map<PersonnageCombattant, Object[]> actions, PersoGroupe perso, int iteration) {
        configPanel();
        int nextIteration = iteration + 1 ;
        JPanel panelFight = new JPanel(); // Create the main panel to contain the options and validate button
        panelFight.setBounds(700, 200, 150, 300);
        layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);
        panelFight.setLayout(new FlowLayout());
        panelFight.setBackground(Color.PINK);



        ButtonGroup buttonGroup = new ButtonGroup();  // Create a button group to handle radio button selection
        if (actions.get(perso)[0] instanceof CompetenceDammage) {
            for (int j = 0; j < node.getOpponents().size(); j++) {
                JRadioButton radioButton = new JRadioButton(node.getOpponents().get(j).getName());
                radioButton.setActionCommand(node.getOpponents().get(j).getName());
                buttonGroup.add(radioButton);
                panelFight.add(radioButton);             
            }
        } else {
            for (int j = 0; j < Game.getGroupeJoueur().size(); j++) {
                JRadioButton radioButton = new JRadioButton(Game.getGroupeJoueur().get(j).getName());
                radioButton.setActionCommand(Game.getGroupeJoueur().get(j).getName());
                buttonGroup.add(radioButton);
                panelFight.add(radioButton);             
            }
        }
            JButton validateButton = new JButton("Valider");// Create and add a button to validate the selected option

            panelFight.add(validateButton);
            getFenetre().add(panelFight);
            getFenetre().setVisible(true);

            validateButton.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) { 
                        PersonnageCombattant c = null ;
                        String n = buttonGroup.getSelection().getActionCommand() ;
                        if (actions.get(perso)[0] instanceof CompetenceDammage) {
                            for (int i=0;i<node.getOpponents().size();i++) {
                                if (node.getOpponents().get(i).getName() == n) {
                                    c = node.getOpponents().get(i) ;
                                }
                            }
                        } else {
                            for (int i=0;i<Game.getGroupeJoueur().size();i++) {
                                if (Game.getGroupeJoueur().get(i).getName() == n) {
                                    c = Game.getGroupeJoueur().get(i) ;
                                }
                            }
                        }
                        actions.get(perso)[1] = c ;
                        selectionAction(node, actions, nextIteration);
                    }
            });
    
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


}