/**
 * The InnerNode class represents an inner node in a hierarchical structure.
 * It extends the Node class.
 */

package Representation;

public class InnerNode extends Node {
	
	private Node nextNode ; // The Node that follows 
	 /**
     * Constructor for an InnerNode without a checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     */
	
	public InnerNode(String nom, String description) {
		super(nom,description);
    }
	
	
	/**
     * Constructor for the Node with the nextNode already defined.
     * @param name The name or title of the Node.
     * @param description The description of the Node.
     * @param isCheckpoint Indicates whether the Node is a checkpoint.
     * @param nextNode The next Node in the sequence.
     */
	
    public InnerNode(String nom, String description, Node nextNode) {
		super(nom,description);
		this.nextNode = nextNode ;
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
     * get the next node
     * @return the next node 
     */
    
	public Node getNextNode() {
		return nextNode;
	}

	/** 
	 * set the nextNode 
	 * @param nextNode
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}


	/**
     * Move to the next Node while updating the formerNode reference.
     * @return The next Node in the sequence.
     */
   
	/**
     * Main method for testing the InnerNode class.
     */
	
  @Override 
  public display() {
    
	this.goNext(this.getNextNode()) ;
}
