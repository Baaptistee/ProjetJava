package Representation;
import javax.swing.* ;
import Interface.* ;

public abstract class Node extends JFrame {
	
	private static int totalNode = 0; // le nombre total de node qui permet ensuite d'attribuer l'id du node
	private static Node lastCheckPoint;
	private static InterfaceJeu interfac = new InterfaceJeu() ; 
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
	
	// getter et setter pour le dernier checkpoint 
	
	public static void setLastCheckpoint(Node x) {
		
		lastCheckPoint = x ;
	}
	
	public static Node getLastCheckPoint() {
		return lastCheckPoint ;
	}
	
	public static InterfaceJeu getInterface() {
		return interfac ;
	}
	
	// une méthode qui retourne le prochain Node tout en changeant l'argument formerNode de celle-ci
	public Node goNext() {
		
		nextNode.setFormerNode(this) ;
		return this.getNextNode() ; 
	}

	public void isCheckPoint() {
		if (this.getCheckPoint()) { // on vérifie si le Node est un checkpoint ou pas et si c'est le cas on update le checkPoint 
        	
        	setLastCheckpoint(this) ;
        }
		
	}
   
	// La fonction utilisée pour afficher les noeuds 
	// A revoir : créer un bouton suivant permettant d'aller au noeud suivant et un bouton précédent permettant de revoir la description et le titre du noeud précédent 
	public void display() {
		
		
		this.isCheckPoint() ;
		
		getInterface().afficherNodeBase(this) ;
	}
	
	/*
	public static ArrayList<Node> creerNodes(String[][] infosNodes) {
        ArrayList<Node> nodes = new ArrayList<>();

        for (String[] info : infosNodes) {
            if (info.length == 2) {
                String nom = info[0];
                String description = info[1];
                nodes.add(new Node(nom, description));
            }
        }

        return nodes;
    }

	
	public static void instanceNode(){
		String[][] infosNodes = {
            {"Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... "},
            {"Node next", "<html> vous devez prouver votre innocence et vous battre pour vous"},
            {"gbhnj", "vghswdfgyhuihygtfrdeftyghujib"},
            {"gbhhnj", "vghswdfgyhuihygtfedrtfgyhujikokjihuygcfghjknrdeftyghujib"}
        };

        ArrayList<Node> nodes = creerNodes(infosNodes);
		
		int i =0 ;
		while( i <nodes.size()){
		nodes.get(0).display();
		nodes.get(i).setNextNode(nodes.get(i+1));
		i++;
		}
	}
	
	*/
	// la méthode main qui sert à tester 
	
	
	
}
