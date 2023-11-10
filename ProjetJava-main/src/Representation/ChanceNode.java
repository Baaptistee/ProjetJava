package Representation;
import java.util.ArrayList;
import java.util.Random;


public class ChanceNode extends InnerNode{

    private  ArrayList <Integer> probability;


    /**
     * Constructs a ChanceNode with a name and description.
     *
     * @param nom         The name of the ChanceNode.
     * @param description The description of the ChanceNode.
     * @param nodePossible the entire of node possible
     * @param probability the probability of each possible node
     */ 

    public ChanceNode(String nom, String description, ArrayList <Node> options, ArrayList <Integer> probability){
        super(nom, description, options);
        
        this.probability=probability;
    }

    public ArrayList <Integer> getProbability(){
        return probability;
    }

    public void setProbability(ArrayList <Integer> probability){
        this.probability=probability;
    }

    /**
     * Select a node based on a random outcome.
     *
     * @return The selected node.
     */
        public Node select() {
            Random random = new Random();
            int randomNum = random.nextInt(10); 

            if (randomNum <=  this.getProbability().get(0)) {
                
                return this.getOptions().get(0); 
            } else {
              
                return this.getOptions().get(1);
            }
        }
        public void goNext() {
            Node a = this.select() ;
            a.setFormerNode(this);
            a.display();
        }
}
