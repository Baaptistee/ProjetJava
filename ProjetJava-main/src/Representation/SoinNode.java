package Representation;

import java.util.ArrayList;

/**
 * The SoinNode class represents a node in the game that provides healing to the players.
 * It extends the TextNode class.
 */
public class SoinNode extends TextNode {

    /**
     * Constructs a SoinNode with the specified parameters.
     *
     * @param nom         The name of the SoinNode.
     * @param description The description of the SoinNode.
     * @param checkPoint  Indicates whether the SoinNode is a checkpoint.
     * @param option      The list of options available for the SoinNode.
     * @throws IllegalArgumentException If any of the parameters are invalid (null or negative).
     */
    public SoinNode(String nom, String description, boolean checkPoint, ArrayList<Node> option) throws IllegalArgumentException {
        super(nom, description, checkPoint, option);
    }

    /**
     * Overrides the display method to provide healing to the players.
     */
    @Override
    public void display() {
        try {
            // Heal each player in the group
            for (int i = 0; i < Game.getGame().getGroupeJoueur().size(); i++) {
                // Set life points to maximum
                Game.getGame().getGroupeJoueur().get(i).setLifePoints(Game.getGame().getGroupeJoueur().get(i).getMaxLifePoints());
                // Set mana to maximum
                Game.getGame().getGroupeJoueur().get(i).setMana(Game.getGame().getGroupeJoueur().get(i).getMaxMana());
                // Set the player as alive
                Game.getGame().getGroupeJoueur().get(i).setAlive(true);
            }
            // Call the superclass display method
            super.display();
        } catch (Exception e) {
            // Handle the exception, you can print a message or log it
            System.err.println("Error in SoinNode display method: " + e.getMessage());
        }
    }
}

