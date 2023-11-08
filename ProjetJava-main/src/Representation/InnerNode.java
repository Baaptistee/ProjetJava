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

	
}
