package Representation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.* ;
import java.awt.*;

public class Node {
	
	private static int totalNode = 0; // le nombre total de node qui permet ensuite d'attribuer l'id du node
	private static Node lastCheckPoint;
	private static JFrame fenetre = new JFrame("Notre super jeu"); // fenetre de jeu qui sera utilisée tout le jeu par tous les nodes
	private static JMenuBar barreMenu = new JMenuBar() ; // barre de menu en argument static 
	
	private String description ; // la description du Node 
	private int idNode ; // l'attribut ID du Node 
	private String nom ; // le nom ou titre du Node 
	private Node nextNode ; // le Node qui viendra après 
	private Node formerNode ; // le Node précédent (pour pouvoir ensuite l'afficher)
	private boolean checkPoint = false ;


	
	// le constructeur :
	public Node(String nom, String description) {
		
		this.idNode = totalNode++ ; // comme on a une incrémentation à chaque création de nouveau Node on est sur d'avoir un ID différent à chaque fois
		this.description = description ;
		this.nom = nom ;
	}
	
	//mise en place d'un attribut check point avec un constructeur spécifique 
	public Node(String nom, String description, boolean checkPoint) {
		
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ; 
	}
	
	// constructeurs avec le nextNode déjà défini
	
	public Node (String nom, String description, boolean checkPoint, Node nextNode) {
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ; 
		this.nextNode = nextNode ;
		
	}
	
	public Node (String nom, String description, Node nextNode) {
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		
	}

	// le setter et getter pour description
	public void setDescription(String newDescription) {
		
		this.description = newDescription ;
		
	}

	public String getDescription() {
		
		return this.description ;
	}

	// le setter et getter pour nom

	public void setNom(String newNom) {
		
		this.nom = newNom ; 
	}
	
	
	public String getNom() {
		
		return this.nom ;
	}
	// le getter pour ID
	public int getID() {
		
		return this.idNode;
	}
	// les setter et getter pour Former Node
	public Node getFormerNode() {
		
		return this.formerNode ;
		}
	
	public void setFormerNode (Node formerNode) {
		this.formerNode = formerNode ;
	}
	// le setter et getter pour nextNode
	public Node getNextNode() {
		return this.nextNode ;
		
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode ; 
		
	}
	// les getter et setter 
	public boolean getCheckPoint() {
		return this.checkPoint ;
	}
	
	public void setCheckPoint(boolean x) {
		this.checkPoint = x ;
	}
	
	public void checkPointTrue() {
		this.checkPoint = true ;
	}
	
	// un getter pour la fenêtre de jeu 
	public static JFrame getW() {
		return fenetre ;
	}
	
	// getter et setter pour le dernier checkpoint 
	
	public static void setLastCheckpoint(Node x) {
		
		lastCheckPoint = x ;
	}
	
	public static Node getLastCheckPoint() {
		return lastCheckPoint ;
	}
	
	public static JMenuBar getBarreMenu() {
		return barreMenu ;
	}
	// une méthode qui retourne le prochain Node tout en changeant l'argument formerNode de celle-ci
	public Node goNext() {
		
		nextNode.setFormerNode(this) ;
		return this.getNextNode() ; 
	}

	//paramétrage de la barre de menu 
	public static void configMenu() { 
		
		JMenu inventaire = new JMenu("Inventaire") ;
		JMenu histoire = new JMenu ("Histoire") ;
		
		JMenuItem precedent = new JMenuItem("Voir précédent") ;
		JMenuItem resumeH = new JMenuItem("Résumé de l'histoire") ;
		
		histoire.add(precedent) ;
		histoire.add(resumeH) ;
		
		getBarreMenu().add(histoire) ;
		getBarreMenu().add(inventaire) ;
		
		getW().setJMenuBar(getBarreMenu());

	
		
	}
	
	//paramétrage de la fenêtre de jeu (méthode appelée une seule fois au début du jeu) 
	public static void gameWindow() {
        getW().setSize(1000, 1000); //taille fenetre
        getW().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; //sortir correctement de la fenetre
        getW().setLocationRelativeTo(null); // centrer la fenetre sur l'ecran
		getW().setVisible(true); // rendre la fenetre visible
		configMenu() ;

	}
	
	
	// La fonction utilisée pour afficher les noeuds 
	// A revoir : créer un bouton suivant permettant d'aller au noeud suivant et un bouton précédent permettant de revoir la description et le titre du noeud précédent 
	public void display() {
		getW().getContentPane().removeAll(); // on clean le frame 

		getW().revalidate(); // on actualise l'affichage
		getW().repaint();
		getW().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints(); // Utilisation d'un gestionnaire de mise en page FlowLayout

        if (this.getCheckPoint()) { // on vérifie si le Node est un checkpoint ou pas et si c'est le cas on update le checkPoint 
        	
        	setLastCheckpoint(this) ;
  
        }
        
        JLabel label = new JLabel("", JLabel.CENTER);// affichage description Node
        constraints.gridx = 0;
        constraints.gridy = 0;
        getW().add(label, constraints); //ajout du label a la fenetre


        
        char[] texts = getDescription().toCharArray(); // transformation de la chaine descrition en tableau de char
        Timer timer = new Timer(20, new ActionListener() { // timer apparition d'un char composant le tableau ci-dessus toutes les 20milisec
            int index = 0; // index pour recuperer chaque char par l'intermediaire du tableau

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < texts.length) { //Parcours de la chaine Descrition caractère par caractère grace au tableau texts
                    char nextChar = getDescription().charAt(index); // recuperation dans la chaine de caractere du caractere associé a l'index
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
                    
                    JButton btn1 = new JButton("Suivant"); // création button
                    constraints.gridx = 0;
                    constraints.gridy = 1;
                    getW().add(btn1,constraints); // ajout du bouton a la fenetre
                    getW().revalidate() ;
                    btn1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Code à exécuter lorsque le bouton est cliqué
                        	goNext() ;
                        	nextNode.display() ; 
                        }
                    });
                   
                    


                    /*Timer timer2 = new Timer(20, new ActionListener() {
                        boolean a=true;
                        int b=0;
                        public void actionPerformed(ActionEvent e) {
                            while(b==0){
                                if(a==true){
                                label.setText(label.getText()+"|");
                                a=false;
                            }
                            else{
                                 label.setText(label.getText());
                                 a=true;
                            }
                            }                         
                        }
                    }); 
                    
                    Faire clignoter le curseur en attendant la réponse du joueur. A REVOIR */


                }
                
            }
        });
        
        
        timer.start();
        
		
	}
	
	/*
	// la méthode main qui sert à tester 
	public static void main(String[] args) {
		gameWindow() ;
		Node test = new Node("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ") ; // balise html a revoir
		Node test2 = new Node("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;
		test.setNextNode(test2) ;
		test.display();


	}*/
	
	
	
}
