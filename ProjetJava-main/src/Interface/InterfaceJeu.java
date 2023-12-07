/**
* Represents the game interface that displays nodes and allows interactions.
*/

package Interface;
import Representation.* ;
import univers.competences.CompetencesActives;
//import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageAdversaire;
import univers.personnages.PersonnageCombattant;
//import univers.* ;
import univers.competences.CompetenceDammage;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.List;

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
        //JButton btn = new JButton("TEST POPUP");
        //panelText.add(btn);
        //POPUP(btn);


	
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
     * La fonction pour lancer le fight node 
     * @param node
     */
    public void playFightNode(Node node){
        FightNode node1 = (FightNode) node ;
         configPanel();
      
        // Create a panel for the "Next" button
        JPanel panelInner = new JPanel();
        getFenetre().add(layeredPane);
		panelInner.setBounds(711, 494, 144, 62);
        
        // Add the "Next" panel to the layered pane
		layeredPane.add(panelInner, JLayeredPane.POPUP_LAYER);
        panelInner.setBackground(Color.yellow);
        
        
        JButton suivant = new JButton("C'est Parti !"); // Create a "Next" button
        suivant.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        suivant.setBackground(new Color(240, 240,240));
		suivant.setForeground(new Color(128, 64, 0));
        panelInner.add(suivant);
        getFenetre().revalidate() ;
        suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                        playTourFightNode(node1) ; // une fois le bouton cliqué on lance le premier tour du fightNode    
                    	
                        }
            });

    }

    
    /**
     * La fonction qui se joue à chaque nouveau tour du combat
     * @param node
     */
    public void playTourFightNode(FightNode node) {
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        
	    getFenetre().getContentPane().setLayout(null);
	    cleanFenetre() ;
        JPanel panelText= new JPanel();
    
        panelText.setBounds(60, 110, 600, 100);
        
        layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
        getFenetre().add(layeredPane);
        JLabel label = new JLabel("Choisissez les compétences et les cibles de vos personnages :", JLabel.CENTER);
        panelText.add(label);
        panelText.setBackground(Color.CYAN); 
        label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        getFenetre().revalidate();
        getFenetre().repaint();
        
        node.videActions(); //On vide la variable actions du FightNode
        selectionAction(node ,0); // on lance la sélection des actions
        
    }

/**
 * La fonction pour sélectionner la compétence du personnage 
 * @param node
 * @param perso // le personnage auquel on est dans le groupe
 */
public void selectionAction(FightNode node, int perso) {
        configPanel();
        JPanel panelFight = new JPanel();
        panelFight.setBounds(700, 200, 150, 300);
        layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);
        panelFight.setLayout(new FlowLayout());
        panelFight.setBackground(Color.PINK);
    
        ButtonGroup buttonGroup = new ButtonGroup();
        JLabel cmp = new JLabel(Game.getGroupeJoueurVivant().get(perso).getName(), JLabel.CENTER);
            panelFight.add(cmp);
        for (int j = 0; j < Game.getGroupeJoueurVivant().get(perso).getCompetences().size(); j++) {
            JRadioButton radioButton = new JRadioButton(Game.getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName());
            radioButton.setActionCommand(Game.getGroupeJoueurVivant().get(perso).getCompetences().get(j).getName());
            buttonGroup.add(radioButton);
            panelFight.add(radioButton); // on crée un radio button pour chacune des compétences du personnage
        }
    
        JButton validateButton = new JButton("Valider");
        panelFight.add(validateButton);
        validateButton.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) { 
                       CompetencesActives competence = null ;
                        String n = buttonGroup.getSelection().getActionCommand() ;
                        for (int i = 0 ; i<Game.getGroupeJoueurVivant().get(perso).getCompetences().size();i++) {
                            if (Game.getGroupeJoueurVivant().get(perso).getCompetences().get(i).getName().equals(n)) {
                                competence = Game.getGroupeJoueurVivant().get(perso).getCompetences().get(i) ;
                            } // on récupère la compétence (un radio button ne peut renvoyer qu'un String)
                        }
                        if (competence.isGroup()) { // si la compétence est une de groupe on apsse directement à la sélection suivante
                            Object[] cibleComp = {competence,null} ;
                            node.putAction(Game.getGroupeJoueurVivant().get(perso), cibleComp);
                            if (perso + 1 == Game.getGroupeJoueurVivant().size()) { // on s'arrête si on a fini tous les persos
                                selectionAdverse(node) ;
                            } else {
                                selectionAction(node, perso+1);
                            }
                        } else {
                            Object[] cibleCompetence = {competence, null};   
                            selectionCible(node, perso, cibleCompetence) ; // on va sélectionner la cible de la compétence                             
                        }
                        layeredPane.remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    }
                    
                });        
         getFenetre().add(layeredPane);
         getFenetre().setVisible(true); 
    }

    /**
     * La fonction pour sélectionner la cible d'une compétence 
     * @param node
     * @param perso
     * @param cibleCompetence
     */
    public void selectionCible(FightNode node, int perso, Object [] cibleCompetence) {
        configPanel();
        JPanel panelFight = new JPanel(); 
        panelFight.setBounds(700, 200, 150, 300);
        layeredPane.add(panelFight, JLayeredPane.POPUP_LAYER);
        panelFight.setLayout(new FlowLayout());
        panelFight.setBackground(Color.PINK);
    
        ButtonGroup buttonGroup = new ButtonGroup();  
        JLabel cmp = new JLabel("Cible du " + Game.getGroupeJoueurVivant().get(perso).getName(), JLabel.CENTER);
        panelFight.add(cmp);
        if (cibleCompetence[0] instanceof CompetenceDammage) {
            for (int j = 0; j < node.getOpponentsVivant().size(); j++) {
                JRadioButton radioButton = new JRadioButton(node.getOpponentsVivant().get(j).getName());
                radioButton.setActionCommand(node.getOpponentsVivant().get(j).getName());
                buttonGroup.add(radioButton);
                panelFight.add(radioButton);
            }
        } else {
            for (int j = 0; j < Game.getGroupeJoueurVivant().size(); j++) {
                JRadioButton radioButton = new JRadioButton(Game.getGroupeJoueurVivant().get(j).getName());
                radioButton.setActionCommand(Game.getGroupeJoueurVivant().get(j).getName());
                buttonGroup.add(radioButton);
                panelFight.add(radioButton);
            }
        }
        JButton validateButton = new JButton("Valider");
    
        panelFight.add(validateButton);
    
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonnageCombattant cible = null;
                String n = buttonGroup.getSelection().getActionCommand();
                
                if (cibleCompetence[0] instanceof CompetenceDammage) {
                    for (int i = 0; i < node.getOpponentsVivant().size(); i++) {
                        if (node.getOpponentsVivant().get(i).getName().equals(n)) {
                            cible = node.getOpponentsVivant().get(i);
                        }
                    }
                } else {
                    for (int i = 0; i < Game.getGroupeJoueur().size(); i++) {
                        if (Game.getGroupeJoueur().get(i).getName().equals(n)) {
                            cible = Game.getGroupeJoueur().get(i) ;
                        }
                    }
                }

                cibleCompetence[1] = cible ;
                node.putAction(Game.getGroupeJoueurVivant().get(perso), cibleCompetence) ;
                if (perso + 1 < Game.getGroupeJoueurVivant().size()) {
                    // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                        getFenetre().remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    selectionAction(node, perso +1 );
                } else {
                    // i use getFenetre() and note layeredpane because it doesn't delet panelfight
                        getFenetre().remove(panelFight);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    selectionAdverse(node);      
                } 
            }  
        });

        getFenetre().add(panelFight);
        getFenetre().setVisible(true);
    }

    /**
     * La fonction pour sélection des capacités ennemies 
     * @param node
     */
    public void selectionAdverse(FightNode node) {
        // pour chaque opponent on lui attribue une action
        for (int i = 0; i<node.getOpponentsVivant().size();i++) {
            CompetencesActives competence = ((PersonnageAdversaire)node.getOpponentsVivant().get(i)).selectionAttaque() ;
            Object[] competenceCible = {competence, ((PersonnageAdversaire)node.getOpponentsVivant().get(i)).selectionCible(competence)} ;
            node.putAction(node.getOpponentsVivant().get(i), competenceCible);
        }
        faireActions(node);
    }
    
    /**
     * la fonction pour exécuter les compétences et récupérer leur texte
     * @param node
     */
    public void faireActions(FightNode node) {
        
        // on transforme la map d'action en une arraylist

        Set<PersonnageCombattant> a = node.getAction().keySet();
        ArrayList<PersonnageCombattant> ordreDAction = new ArrayList<PersonnageCombattant>(a);
    // on trie la liste en fonction de la vitesse des personnages 
        Collections.sort(ordreDAction, Comparator.comparingInt(PersonnageCombattant::getSpeed));

        String txt = "" ;
        String texteAction ="" ;
        // le nombre d'action du tour 
        int nombreAction = ordreDAction.size() ;
        // boucle pou créer le texte avec toutes les actions 
        for (int i = 0; i < ordreDAction.size() ;i++) {
            PersonnageCombattant utilisateur = ordreDAction.get(i) ;
            if(utilisateur.enVie() == false){
                texteAction += "$" ;
                continue ;
            }
            PersonnageCombattant cible = (PersonnageCombattant)node.getAction().get(ordreDAction.get(i))[1] ;
            CompetencesActives competence = (CompetencesActives)node.getAction().get(ordreDAction.get(i))[0] ;
        
            txt = (competence.utilisation(utilisateur, cible));
            
            if (txt == "nope"){ // la fonction competence d'utilisation renvoie "nope" si rien ne se passe 
                texteAction += "$" ;
                continue ;
            }

            texteAction += txt + "$"; // on va se servir du charactère dollar un peu de la même manière dont on s'est servi du charactère "/" 
            
        }

        // puis on lance la fonction afficher action qui permet d'afficher les actions 
        //System.out.println(texteAction);
        afficherAction(node, texteAction, nombreAction, 0, 0);
    }

    /**
     * La fonction pour afficher le résultat du tour
     * Les actions sont affichées 12 lignes par 12
     * @param node
     * @param texteAction
     * @param nombreAction
     * @param ligneAffichee
     * @param actionAffichee
     */
    public void afficherAction(FightNode node, String texteAction, int nombreAction, int ligneAffichee, int actionAffichee){  
        configPanel();
        layeredPane.removeAll();
        layeredPane.revalidate();
        layeredPane.repaint();
        if (nombreAction-actionAffichee> 0) {

	        getFenetre().getContentPane().setLayout(null);
	        cleanFenetre() ;
            JPanel panelText= new JPanel();
        
            panelText.setBounds(80, 110, 850, 300);
            layeredPane.add(panelText, JLayeredPane.POPUP_LAYER);
            getFenetre().add(layeredPane);
            JLabel label = new JLabel("<html>", JLabel.CENTER);// Create a label for displaying the description of the node
            panelText.add(label);
            panelText.setBackground(Color.CYAN); 
            label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
            getFenetre().revalidate();
            getFenetre().repaint();
            int action = 0 ;
            int debut = 0; 
            int ligne = 0 ;
            char[] texts = texteAction.toCharArray(); 

            if (ligneAffichee != 0) {
                    do {
                        if (texts[debut]=='/'){
                            ligne++ ; // on compte le nombre de lignes déjà affichées pour ajuster l'index de début
                        }
                        if (texts[debut]=='$'){
                            action++; // on compte le nombre d'actions déjà affichées pour savoir quand s'arrêter 
                        }
                        debut++ ;
                     } while(ligne < ligneAffichee) ;
                }
            
            final int debut2 = debut ;
            final int action2 = action ;
            
            Timer timer = new Timer(20, new ActionListener(){ // Create a timer to display the description character by character
            int index = debut2 ;
            int action3 = action2 ;
            int nbAction = 0 ;
            int nbLigne = 0 ;
                @Override
                    public void actionPerformed(ActionEvent e){
                        if (index < texts.length) { 
                            if (nbLigne<12){
                                char nextChar = texteAction.charAt(index); 
                                if(nextChar =='/'){  
                                    label.setText(label.getText() + "<br>");
                                    index++;
                                    nbLigne++ ;
                                } else if(nextChar == '$') {
                                    index++ ;
                                    nbAction++ ;
                                } else {
                                    label.setText(label.getText() + nextChar); 
                                    index++; //on passe au caractere suivant de la chaine de description
                                }
                            } else {
                                index = texts.length ;
                            }
                        } else {
                            ((Timer) e.getSource()).stop(); 
                            ButtonSuivant(node, texteAction, nombreAction, action3 + nbAction, ligneAffichee+12);
                        }
        
                    }
            });
    timer.start();                  
        } else {
            FightOver(node) ;
        }
    }

    public void ButtonSuivant(FightNode node, String texteAction, int nombreAction, int actionAffichee, int ligneAffichee){
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

		    afficherProchaineAction(suivant, node, texteAction, nombreAction, actionAffichee, ligneAffichee) ;
     }
    
      
    public void afficherProchaineAction(JButton suivant, FightNode node, String texteAction, int nombreAction, int actionAffichee, int ligneAffichee) {
        suivant.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) { 
                            afficherAction(node, texteAction, nombreAction, actionAffichee, ligneAffichee);
                        }
            });

    } 

    /**
     * on vérifie si le combat est terminé 
     * @param node
     */
    public void FightOver(FightNode node){
        if (node.isOver()){  // si le combat est terminé on passe au node suivant 
            System.out.println("Combat fini") ;
            node.goNext();
        } else {
        System.out.println("c'est reparti pour un tour !") ; // sinon on continue avec un nouveau tour
        playTourFightNode(node);
        }
    }

    /**
     * la fonction qui selon la valeur renvoyée par le fightNode va lancer le node suivant 
     * @param node
     * @param isvictoire
     */
    public void VictoireDefaite(FightNode node, boolean isvictoire) {
        System.out.println("victoire défaite") ;
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
        JLabel label = new JLabel("<html>", JLabel.CENTER);// Create a label for displaying the description of the node
        panelText.add(label);
        panelText.setBackground(Color.CYAN); 
        label.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        getFenetre().revalidate();
        getFenetre().repaint();
        
        String q = "" ;
        Node nodeNext = null ;

        if(isvictoire){
            q = "Vous avez gagné bravo ! " ;
            nodeNext = node.getOptions().get(0) ;
        } else {
            nodeNext = node.getOptions().get(1) ;
            q = "Vous avez perdu, dommage, peut-être une autre fois ..." ;
        }

        final Node nodeNext2 = nodeNext ;
        final String texte = q ;

        char[] texts = q.toCharArray(); // Convert the description text of the node to a character array
        Timer timer = new Timer(20, new ActionListener() { // Create a timer to display the description character by character
        int index = 0; // Index to retrieve each character from the description


        @Override
            public void actionPerformed(ActionEvent e) {
                if (index < texts.length) { 
                    char nextChar = texte.charAt(index); 
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
                    nextNodeButton(nodeNext2) ;
                    }
                }
            });
            timer.start(); 
    }

    public void nextNodeButton(Node nodeNext){
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

        suivant.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) { 
                    nodeNext.display();
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