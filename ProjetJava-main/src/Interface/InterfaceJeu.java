package Interface;

import Representation.* ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.* ;


public class InterfaceJeu {
	
	private static JFrame fenetre = new JFrame();
	private static JMenuBar barreMenu = new JMenuBar() ;
	private static JLayeredPane panelAffichage = new JLayeredPane() ; 


	
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

public static JLayeredPane getPane() {
	return panelAffichage ;
}


public static void setBarreMenu(JMenuBar barreMenu) {
	InterfaceJeu.barreMenu = barreMenu;
}


public static void cleanFenetre() {
	getFenetre().getContentPane().removeAll();
	getFenetre().revalidate() ;
	getFenetre().repaint();
}

public static void cleanPane() {
	getPane().removeAll() ;
	getFenetre().revalidate() ;
	getFenetre().repaint();
}


public static void cleanLayer(int layer) {
	Component[] components = getPane().getComponentsInLayer(layer);
	for (Component component : components) {
	    //getPane().remove(component);
	}
}


public static void configMenu() {
	//méthode paramétrant le menu
	
	JMenu inventaire = new JMenu("Inventaire") ;
	JMenu histoire = new JMenu ("Histoire") ;
	JMenu statut = new JMenu ("Statut") ;
	
	JMenuItem precedent = new JMenuItem("Voir précédent") ;
	JMenuItem resumeH = new JMenuItem("Résumé de l'histoire") ;
	
	histoire.add(precedent) ;
	histoire.add(resumeH) ;
	
	getBarreMenu().add(histoire) ;
	getBarreMenu().add(inventaire) ;
	getBarreMenu().add(statut) ;
	
	
	getFenetre().setJMenuBar(getBarreMenu());

}



public static void configFenetre() {
//Méthode qui paramètre la fenêtre
getFenetre().setSize(1000, 1000); //taille fenetre
getFenetre().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
getFenetre().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
getFenetre().setLayout(new BorderLayout());
configMenu() ;
//getPane().setLayout(new BorderLayout());
//getPane().setBounds(0,0,1000, 1000) ;
//getFenetre().add(getPane()) ;
getFenetre().setVisible(true); // rendre la fenetre visible

}	
	char[] texts = description.toCharArray(); // transformation de la chaine descrition en tableau de char
    Timer timer = new Timer(20, new ActionListener() { // timer apparition d'un char composant le tableau ci-dessus toutes les 20milisec
    int index = 0 ; // index pour recuperer chaque char par l'intermediaire du tableau
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (index < texts.length) { //Parcours de la chaine Descrition caractère par caractère grace au tableau texts
            char nextChar = description.charAt(index); // recuperation dans la chaine de caractere du caractere associé a l'index
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
            
            
			//CreateCloseButton(getPane());
        }
        
    }
});


timer.start();
}



	JButton fermer = new JButton("Fermer"); // création button
    //constraints.gridx = 0;
    //constraints.gridy = 1;
    pane.add(fermer,BorderLayout.SOUTH); // ajout du bouton a la fenetre
	//constraints.gridx = 1;
    //constraints.gridy = 1;
    getFenetre().revalidate() ;
	boutonClosePane(fermer, pane) ;
	
}

public static void retirer (Component component) {
	
	getFenetre().remove(component);
}

public static void boutonClosePane(JButton btn, JLayeredPane pane) {
	
	btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//cleanLayer(layer) ;
				retirer(btn) ;
				retirer(pane) ;
			}
			});
}
    getFenetre().revalidate();
    getFenetre().repaint();

	
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
            
            
			CreatNextButton(getPane(), BorderLayout.SOUTH, node);
        }
        
    }
});


timer.start(); 

}



public void CreatNextButton(JLayeredPane pane, String tqt, Node node){
	JButton suivant = new JButton("Suivant"); // création button
                pane.add(suivant, tqt, JLayeredPane.DEFAULT_LAYER); // ajout du bouton a la fenetre
                pane.revalidate() ;
				boutonGoNext(suivant, node);
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
