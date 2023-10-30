/**
 * The InnerNode class represents an inner node in a hierarchical structure.
 * It extends the Node class.
 */

package Representation;

public class InnerNode extends Node {

	 /**
     * Constructor for an InnerNode without a checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     */

    public InnerNode(String nom, String description) {
		super(nom,description);
	}

	/**
     * Constructor for an InnerNode with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param checkpoint Indicates whether the inner node is a checkpoint.
     */

    public InnerNode(String nom, String description, boolean checkPoint) {

        super(nom,description,checkPoint);
    }
    
	/**
     * Main method for testing the InnerNode class.
     */
	
    public static void main(String[] args) {
		
		// Create two InnerNode instances for testing
		InnerNode test = new InnerNode("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ") ; // balise html a revoir
		InnerNode test2 = new InnerNode("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;
		
		// Set a next node for 'test'
		test.setNextNode(test2) ;
		
		// Display the information of 'test'
	    test.display() ;
		
		
	}
	
}
