package Representation;
import java.util.ArrayList;
import java.util.Random;


public class ChanceNode extends Node{

    private static ArrayList <Node> nodePossible;
    private static int [] proba= {6,4};


    /**
     * Constructs a ChanceNode with a name and description.
     *
     * @param nom         The name of the ChanceNode.
     * @param description The description of the ChanceNode.
     */ 

    public ChanceNode(String nom, String description){
        super(nom, description);
        if (nodePossible == null) {
            nodePossible = new ArrayList<>();
            nodePossible.add(new ChooseNode("Interrogatoire", "Vous etes suspecté de complicité avec le prince. Repondez a cet interrogatoire de maniere a enlever tout soupcon ...", nodePossible));
            nodePossible.add(new InnerNode("Detente a la caserne", "Vous tombé sur une caserne et decidez de faire une pause pour décompresser"));
        }
    }

    /**
     * Get the possible nodes that can be selected based on chance.
     *
     * @return A list of possible nodes.
     */

    public ArrayList <Node> getNodePossible() {
		return nodePossible ;
	}

    /**
     * Select a node based on a random outcome.
     *
     * @return The selected node.
     */
        public Node select() {
            Random random = new Random();
            int randomNum = random.nextInt(10); 

            if (randomNum <=  proba[0]) {
                
                return getNodePossible().get(0); 
            } else {
              
                return getNodePossible().get(1);
            }
        }

}
