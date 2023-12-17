package Representation;
import java.util.ArrayList;
import java.util.Objects;
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

    public ChanceNode(String nom, String description, ArrayList <Node> options,String imageName,ArrayList <Integer> probability){
        super(nom, description,imageName, options);
        this.probability=probability;
    }

    public ChanceNode(String nom,String description, ArrayList <Integer> probability){
        super(nom, description, false);
        
        this.probability=probability;
    }
     public ChanceNode(String description, ArrayList <Integer> probability){
        super("Node" + Node.getTotalNode()+1, description, false);
        
        this.probability=probability;
    }

    public ArrayList <Integer> getProbability(){
        return probability;
    }

    public void setProbability(ArrayList <Integer> probability){
        this.probability=probability;
    }
    
    @Override
    public String toString() {
        return "ChanceNode:"+super.toString();
    }

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

        @Override
        public String toString() {
            return "ChanceNode:"+super.toString();
        }

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
