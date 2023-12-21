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
     * @param nom The name of the SoinNode.
     * @param description The description of the SoinNode.
     * @param checkPoint Indicates whether the SoinNode is a checkpoint.
     * @param option The list of options available for the SoinNode.
     */
    public SoinNode(String nom, String description, boolean checkPoint, ArrayList<Node> option){
        super(nom, description, checkPoint, option);
    }

    /**
     * Overrides the display method to provide healing to the players.
     */
    @Override
    public void display() {
        if (Game.getGame().getGroupeJoueur().isEmpty()) {
            throw new IllegalStateException("Le groupe de joueur est vide");
        }
            for (int i = 0; i < Game.getGame().getGroupeJoueur().size(); i++) {
                Game.getGame().getGroupeJoueur().get(i).setLifePoints(Game.getGame().getGroupeJoueur().get(i).getMaxLifePoints());
                Game.getGame().getGroupeJoueur().get(i).setMana(Game.getGame().getGroupeJoueur().get(i).getMaxMana());
                Game.getGame().getGroupeJoueur().get(i).setAlive(true);
            }
            super.display();
       
    }
}
