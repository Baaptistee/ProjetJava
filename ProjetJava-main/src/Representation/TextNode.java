package Representation;

import java.util.ArrayList;

/** 
 * A class representing a node that has only one possible transition node.
 * It serves as a transition node between, for example, a ChanceNode and a FightNode.
 */
public class TextNode extends InnerNode {

    /**
     * Constructor for a TextNode with specified parameters.
     *
     * @param nom          The name of the text node.
     * @param description  The description of the text node.
     * @param imageName    The name of the associated image.
     * @param checkPoint   Indicates whether the text node is a checkpoint.
     * @param options      The list of available options for the text node.
     */
    public TextNode(String nom, String description, String imageName, ArrayList<Node> options){
        super(nom, description, imageName, options);
    }

    

    /**
     * Constructor for a TextNode with specified parameters.
     *
     * @param nom          The name of the text node.
     * @param description  The description of the text node.
     * @param imageName    The name of the associated image.
     * @throws IllegalArgumentException If the provided options are null.
     */
    public TextNode(String nom, String description, String imageName) {
        super(nom, description, imageName);
    }

    /**
     * Constructor for a TextNode with specified parameters.
     *
     * @param description  The description of the text node.
     * @param imageName    The name of the associated image.
     * @throws IllegalArgumentException If the provided options are null.
     */
    public TextNode(String description, String imageName) throws IllegalArgumentException {
        super("Node" + Node.getTotalNode() + 1, description);
    }


  
    public Node goNext() {
		this.getOptions().get(0).setFormerNode(this);
		return this.getOptions().get(0) ;
	}

    /**
     * Returns a string representation of the TextNode.
     *
     * @return A string representation of the TextNode.
     */
    @Override
    public String toString() {
        return "TextNode:" + super.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Overrides the default equals method.
     *
     * @param obj The reference object with which to compare.
     * @return True if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        TextNode textNode = (TextNode) obj;

        return super.equals(obj) && getOptions().equals(textNode.getOptions());
    }
}
