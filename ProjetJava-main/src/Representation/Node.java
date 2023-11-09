package Representation;
import javax.swing.* ;
import Interface.* ;

public abstract class Node extends JFrame {
	
	private static int totalNode = 0; // le nombre total de node qui permet ensuite d'attribuer l'id du node
	private static Node lastCheckPoint;
	private static InterfaceJeu interfac = new InterfaceJeu() ; 

	private String description ; // The description of the Node
	private int idNode ; // The unique ID of the Node
	private String nom ; //The name of the Node
	private Node formerNode ; // The previous Node (for backward navigation)
	private boolean checkPoint = false ;
	
	 /**
     * Constructor for the Node.
     * @param name The name of the Node.
     * @param description The description of the Node.
     */

	public Node(String nom, String description) {
		this.idNode = totalNode++ ; // Incrementing for a unique ID with each Node creation
		this.description = description ;
		this.nom = nom ;
	}
	
	/**
     * Constructor for the Node with an optional checkpoint.
     * @param name The name of the Node.
     * @param description The description of the Node.
     * @param isCheckpoint Indicates whether the Node is a checkpoint.
     */

	public Node(String nom, String description, boolean checkPoint) {
		
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		this.checkPoint = checkPoint ; 
	}
	
	/**
     * Constructor for the Node with the nextNode already defined.
     * @param name The name or title of the Node.
     * @param description The description of the Node.
     * @param isCheckpoint Indicates whether the Node is a checkpoint.
     * @param nextNode The next Node in the sequence.
     */
	
	
	public Node (String nom, String description, Node nextNode) {
		this.idNode = totalNode++ ;
		this.description = description ;
		this.nom = nom ;
		
	}

	/**
     * Set the description of the Node.
     * @param newDescription The new description to set.
     */

	public void setDescription(String newDescription) {
		
		this.description = newDescription ;
		
	}

	 /**
     * Get the description of the Node.
     * @return The description of the Node.
     */

	public String getDescription() {
		
		return this.description ;
	}

	/**
     * Set the name of the Node.
     * @param newNom The new name to set.
     */

	public void setNom(String newNom) {
		
		this.nom = newNom ; 
	}
	
	  /**
     * Get the name of the Node.
     * @return The name or title of the Node.
     */ 

	public String getNom() {
		
		return this.nom ;
	}


	/**
     * Get the unique identifier (ID) of the Node.
     * @return The ID of the Node.
     */

	public int getID() {
		
		return this.idNode;
	}

	 /**
     * Get the former Node, which is the Node that precedes this one.
     * @return The former Node.
     */

	public Node getFormerNode() {
		
		return this.formerNode ;
		}
	
	 /**
     * Set the former Node, which is the Node that precedes this one.
     * @param formerNode The former Node to set.
     */

	public void setFormerNode (Node formerNode) {
		this.formerNode = formerNode ;
	}

	/**
     * Get the checkpoint status of the Node.
     * @return `true` if the Node is a checkpoint, `false` otherwise.
     */

	public boolean getCheckPoint() {
		return this.checkPoint ;
	}
	
	 /**
     * Set the checkpoint status of the Node.
     * @param x `true` to mark the Node as a checkpoint, `false` otherwise.
     */

	public void setCheckPoint(boolean x) {
		this.checkPoint = x ;
	}
	
	/**
     * Mark the Node as a checkpoint.
     */

	public void checkPointTrue() {
		this.checkPoint = true ;
	}

	/**
     * Set the last checkpoint Node.
     * @param x The last checkpoint Node to set.
     */
	
	public static void setLastCheckpoint(Node x) {
		
		lastCheckPoint = x ;
	}

	/**
     * Get the last checkpoint Node.
     * @return The last checkpoint Node.
     */

	public static Node getLastCheckPoint() {
		return lastCheckPoint ;
	}
	
	/**
     * Get the game interface instance.
     * @return The game interface.
     */

	public static InterfaceJeu getInterface() {
		return interfac ;
	}
	

	 /**
     * Check if the Node is a checkpoint and update the last checkpoint if needed.
     */

	public void isCheckPoint() {
		if (this.getCheckPoint()) { 
        	
        	setLastCheckpoint(this) ;
        }
	}
	
	public void display() {
			this.isCheckPoint() ;
			getInterface().afficherNodeBase(this) ;
	}
	
	public void goNext(Node nextNode) {
		nextNode.setFormerNode(this);
		nextNode.display();
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
	/*
  public static void main(String[] args) {
		
		
		Node test = new Node("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ") ; // balise html a revoir
		Node test2 = new Node("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;
		test.setNextNode(test2) ;
			    
	    test.display() ;	    
	    //getInterface().popUp("test test test test on va voir si ça marche lol") ;
		
	}*/
	
	
	
}
