/**
 * The `InnerNode` class represents an inner node in a hierarchical structure, extending the `Node` class.
 * It provides the functionality to create nodes with multiple options for choices.
 */
package Representation;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents an inner node in the game's narrative structure.
 * Extends the Node class to inherit basic node functionality.
 */
public abstract class InnerNode extends Node {
	
    private ArrayList<Node> options = new ArrayList<>();

    /**
     * Constructor for an `InnerNode` without a checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param imageName The name of the associated image.
     * @param options The list of options available for the choice.
     */
    public InnerNode(String name, String description, String imageName, ArrayList<Node> options){
        super(name, description, imageName);
        this.options = options;
    }

    

    /**
     * Constructor for an `InnerNode` without an explicit checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     */
    public InnerNode(String nom, String description){
		super(nom, description);
	}

    
    /**
     * Constructor for an `InnerNode` without an explicit checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param imageName The name of the associated image.
     */
    public InnerNode(String nom, String description, String imageName){
        super(nom, description, imageName);
    }
   
    /**
     * Constructor for an `InnerNode` without an explicit checkpoint.
     * @param description The description of the inner node.
     * @param imageName The name of the associated image.
     * @param imagepersoPath The list of paths to images associated with characters.
     */
    public InnerNode(String description, String imageName, ArrayList<String> imagepersoPath){
        super("Node" + (Node.getTotalNode() + 1), description, imageName, imagepersoPath);
    }

  
    
    /**
     * Get the list of available options for the choice.
     * @return The list of options.
     */
	public ArrayList <Node> getOptions() {
		return options ;
	}

    /**
     * Set the list of available options for the choice.
     * @param options The list of options to set.
     */
	public void setOptions(ArrayList <Node> options){
		this.options=options;
	}

    /**
     * Add an option to the list of available options.
     * @param optionSupp The option to add.
     * @throws IllegalArgumentException If the provided option is null.
     */
     public void addOption(Node optionSupp){
            if (optionSupp != null) {
                this.getOptions().add(optionSupp);
            } else {
                throw new IllegalArgumentException("Les options qu'on ajoute ne peuvent pas être null");
            }
    }

    /**
     * Remove an option from the list of available options.
     * @param suppOption The option to remove.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
     public void suppOption(Node suppOption){
        int index = this.getOptions().indexOf(suppOption);
            if (index >= 0 && index < this.getOptions().size()) {
                this.getOptions().remove(index);
            } else {
                throw new IndexOutOfBoundsException("Index hors limites : " + index);
            }
    }

	 /**
     * Overrides the display method to display the information of the choice node.
     */
    @Override
    public String toString() {
        return "InnerNode:"+super.toString();
    }

    /**
     * Abstract method representing the behavior of moving to the next node.
     */
	public abstract Node goNext() ;

	@Override
    /**
     * Checks if two InnerNode objects are equal.
     * @param obj The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        InnerNode innerNode = (InnerNode) obj;
        return super.equals(obj) &&
                Objects.equals(getOptions(), innerNode.getOptions());
    }
}