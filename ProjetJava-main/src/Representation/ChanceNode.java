package Representation;
import java.util.ArrayList;
import java.util.Random;


public class ChanceNode extends Node{

    private  ArrayList <Node> nodePossible;
    private  ArrayList <Integer> probability;


    /**
     * Constructs a ChanceNode with a name and description.
     *
     * @param nom         The name of the ChanceNode.
     * @param description The description of the ChanceNode.
     * @param nodePossible the entire of node possible
     * @param probability the probability of each possible node
     */ 

    public ChanceNode(String nom, String description, ArrayList <Node> nodePossible, ArrayList <Integer> probability){
        super(nom, description);
        this.nodePossible=nodePossible;
        this.probability=probability;
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

            if (randomNum <=  probability.get(0)) {
                
                return getNodePossible().get(0); 
            } else {
              
                return getNodePossible().get(1);
            }
        }

}
