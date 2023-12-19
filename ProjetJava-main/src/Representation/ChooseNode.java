/**
 * The ChooseNode class represents a node for making a choice among different options.
 * It extends the Node class.
 */

package Representation;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * The ChooseNode class represents a node for making a choice among different options.
 * It extends the InnerNode class.
 */
public class ChooseNode extends InnerNode {

    /**
     * Constructor for the ChooseNode class.
     *
     * @param nom        The name of the choice node.
     * @param description The description of the choice node.
     * @param imageName   The name of the associated image.
     * @param options     The available options for the choice.
     * @throws IllegalArgumentException If any of the parameters are invalid (null or negative).
     */
    public ChooseNode(String nom, String description, String imageName, ArrayList<Node> options) throws IllegalArgumentException {
        super(nom, description, imageName, options);
    }

    /**
     * Constructor for the ChooseNode class.
     *
     * @param description The description of the choice node.
     * @param imageNode   The name of the associated image.
     * @throws IllegalArgumentException If any of the parameters are invalid (null or negative).
     */
    public ChooseNode(String description, String imageNode) throws IllegalArgumentException {
        super("Node" + Node.getTotalNode() + 1, description, imageNode, false);
    }

    /**
     * Constructor for the ChooseNode class.
     *
     * @param nom        The name of the choice node.
     * @param description The description of the choice node.
     * @param imageNode   The name of the associated image.
     * @throws IllegalArgumentException If any of the parameters are invalid (null or negative).
     */
    public ChooseNode(String nom, String description, String imageNode) throws IllegalArgumentException {
        super(nom, description, imageNode, false);
    }

    /**
     * Constructor for the ChooseNode class.
     *
     * @param description The description of the choice node.
     * @param imageNode   The name of the associated image.
     * @param imagepersoPath The list of image paths for the associated characters.
     * @throws IllegalArgumentException If any of the parameters are invalid (null or negative).
     */
    public ChooseNode(String description, String imageNode, ArrayList<String> imagepersoPath) throws IllegalArgumentException {
        super(description, imageNode, imagepersoPath);
    }

    /**
     * Gets the list of image icons for the associated characters.
     *
     * @return The list of image icons.
     */
    public ArrayList<ImageIcon> ImagePersoList() {
        ArrayList<ImageIcon> optionsImageList = new ArrayList<>();

        for (Node optionNode : getOptions()) {
            if (optionNode instanceof ChooseNode) {
                ArrayList<String> imagePaths = ((ChooseNode) optionNode).getImagePersoList();

                for (String imagePath : imagePaths) {
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    optionsImageList.add(imageIcon);
                }
            }
        }

        return optionsImageList;
    }

    /**
     * Overrides the display method to display the information of the ChooseNode.
     */
    @Override
    public void display() {
        super.display();
    }

    /**
     * Overrides the goNext method for ChooseNode.
     */
    @Override
    public void goNext() {
       
    }

    /**
     * Overrides the toString method to provide a string representation of the ChooseNode.
     *
     * @return A string representation of the ChooseNode.
     */
    @Override
    public String toString() {
        return "Choose Node:" + super.toString();
    }

    /**
     * Overrides the equals method to compare two ChooseNode objects for equality.
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
        return super.equals(obj);
    }
}