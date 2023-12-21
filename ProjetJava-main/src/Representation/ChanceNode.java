/**
 * The ChanceNode class represents a node that introduces a chance-based decision among different options.
 * It extends the InnerNode class.
 *
 * @see InnerNode
 */
package Representation;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * The ChanceNode class represents a node that introduces a chance-based decision among different options.
 * It extends the InnerNode class.
 *
 * @see InnerNode
 */
public class ChanceNode extends InnerNode {

    private ArrayList<Integer> probability;

    /**
     * Constructs a ChanceNode with a name, description, options, image name, and probability for each option.
     *
     * @param nom The name of the ChanceNode.
     * @param description The description of the ChanceNode.
     * @param options The available options for the chance node.
     * @param imageName The name of the associated image.
     * @param probability The probability of each possible node.
     */
    public ChanceNode(String nom, String description, ArrayList<Node> options, String imageName, ArrayList<Integer> probability) {
        super(nom, description, imageName, options);
        this.probability = probability;
    }

    /**
     * Constructs a ChanceNode with a name, description, and probability for each option.
     *
     * @param nom The name of the ChanceNode.
     * @param description The description of the ChanceNode.
     * @param probability The probability of each possible node.
     */
    public ChanceNode(String nom, String description, ArrayList<Integer> probability) {
        super(nom, description, false);
        this.probability = probability;
    }

    /**
     * Constructs a ChanceNode with a default name, description, and probability for each option.
     *
     * @param description  The description of the ChanceNode.
     * @param probability  The probability of each possible node.
     */
    public ChanceNode(String description, ArrayList<Integer> probability) {
        super("Node" + Node.getTotalNode() + 1, description, false);
        this.probability = probability;
    }

    /**
     * Gets the probability of each possible node.
     *
     * @return The list of probabilities.
     */
    public ArrayList<Integer> getProbability() {
        return probability;
    }

    /**
     * Sets the probability of each possible node.
     *
     * @param probability The list of probabilities to set.
     */
    public void setProbability(ArrayList<Integer> probability) {
        if(probability.isEmpty()){
            throw new IllegalStateException("La liste des probabilité est null");
        }
        this.probability = probability;
    }

    /**
     * Selects a node based on a random outcome.
     *
     * @return The selected node.
     */
    public Node select() {
        if (this.getOptions().isEmpty()) {
            throw new IllegalStateException("La liste des options ne peut pas être vide");
        }
        Random random = new Random();
        int randomNum = random.nextInt(10);

        int probability1 = this.getProbability().get(0);
        int probability2 = this.getProbability().get(1);

        if (probability1 < 0 || probability2 < 0 || probability1 + probability2 != 10) {
            throw new IllegalStateException("Les probabilités doivent être des entiers positifs et leur somme doit être égale à 10");
        }

        if (randomNum <= this.getProbability().get(0)) {
            return this.getOptions().get(0);
        } else {
            return this.getOptions().get(1);
        }
    }

    /**
     * Advances to the next node based on the chance outcome.
     */
    public Node goNext() {
        Node selectedNode = this.select();
        selectedNode.setFormerNode(this);
        return selectedNode;
    }

    /**
     * Overrides the toString method to provide a string representation of the ChanceNode.
     *
     * @return A string representation of the ChanceNode.
     */
    @Override
    public String toString() {
        return "ChanceNode: " + super.toString();
    }

    /**
     * Overrides the equals method to compare two ChanceNode objects for equality.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ChanceNode chanceNode = (ChanceNode) obj;
        return super.equals(obj) &&
                Objects.equals(this.getProbability(), chanceNode.getProbability());
    }
}