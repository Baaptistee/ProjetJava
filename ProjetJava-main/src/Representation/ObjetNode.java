package Representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import univers.Collectibles;

/**
 * The ObjetNode class represents a node in the game that provides healing to the players.
 * It extends the TextNode class.
 */
public class ObjetNode extends TextNode{

    private Map<Collectibles, Integer> objets = new HashMap();
    /**
     * Constructs a ObjetNode with the specified parameters.
     *
     * @param nom The name of the ObjetNode.
     * @param description The description of the ObjetNode.
     * @param checkPoint Indicates whether the ObjetNode is a checkpoint.
     * @param option The list of options available for the ObjetNode.
     */
    public ObjetNode(String nom, String description){
        super(nom, description);
    }
public ObjetNode(String nom, String description, Map<Collectibles, Integer> objets){
        super(nom, description);
        this.objets=objets ;
    }
    

    public Map<Collectibles, Integer> getObjets(){
        return this.getObjets();
    }

    public void setObjets(Map<Collectibles, Integer> objets){
        this.objets=objets;
    }

    /**
     * Overrides the display method to provide healing to the players.
     */
    @Override
    public void display() {
            for (Collectibles objet : this.objets.keySet()) {
                for(int i =0; i<this.objets.get(objet);i++){
                    Game.getGame().ajoutInventaire(objet);
                }
            }
            super.display();
       
    }
}