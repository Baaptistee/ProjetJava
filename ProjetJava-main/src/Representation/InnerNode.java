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
     * Constructor for an `InnerNode` with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param options The list of options available for the choice.
     * @param checkPoint Indicates whether the inner node is a checkpoint.
     */
    public InnerNode(String name, String description, ArrayList<Node> options, boolean checkPoint){
        super(name, description, checkPoint);
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
     * Constructor for an `InnerNode` with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param imageName The name of the associated image.
     * @param checkPoint Indicates whether the inner node is a checkpoint.
     * @param options The list of options available for the choice.
     */
    public InnerNode(String nom, String description, String imageName, boolean checkPoint, ArrayList<Node> options){
        super(nom, description, imageName, checkPoint);
        this.options=options;
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
     * Constructor for an `InnerNode` with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param imageName The name of the associated image.
     * @param checkPoint Indicates whether the inner node is a checkpoint.
     */
    public InnerNode(String nom, String description, String imageName, boolean checkPoint){
        super(nom, description, imageName, checkPoint);
    }
  
    /**
     * Constructor for an `InnerNode` with an optional checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param checkPoint Indicates whether the inner node is a checkpoint.
     * @param options The list of options available for the choice.
     * @throws IllegalArgumentException If the provided options are null.
     */
    public InnerNode(String nom, String description, boolean checkPoint, ArrayList<Node> options){
        super(nom, description, checkPoint);
        this.options = options ;
    }

    /**
     * Constructor for an `InnerNode` without an explicit checkpoint.
     * @param name The name of the inner node.
     * @param description The description of the inner node.
     * @param checkPoint Indicates whether the inner node is a checkpoint.
     */
    public InnerNode(String nom, String description, boolean checkPoint){
    	super(nom, description, checkPoint) ;
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
     public void addOption(Node optionSupp) throws IllegalArgumentException {
        try {
            if (optionSupp != null) {
                this.getOptions().add(optionSupp);
            } else {
                throw new IllegalArgumentException("Les options qu'on ajoute ne peuvent pas être null");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Erreur sur l'option ajoutée : " + e.getMessage());
        }
    }

    /**
     * Remove an option from the list of available options.
     * @param suppOption The option to remove.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
     public void suppOption(Node suppOption) throws IndexOutOfBoundsException {
        int index = this.getOptions().indexOf(suppOption);
    
        try {
            if (index >= 0 && index < this.getOptions().size()) {
                this.getOptions().remove(index);
            } else {
                throw new IndexOutOfBoundsException("Index hors limites : " + index);
            }
        } catch (IndexOutOfBoundsException e) {
            // Gère l'exception et affiche un message d'erreur.
            System.err.println("Erreur lors de la suppression de l'option : " + e.getMessage());
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
	public abstract void goNext() ;

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