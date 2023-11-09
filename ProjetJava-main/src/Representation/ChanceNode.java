package Representation;
import java.util.ArrayList;
import java.util.Random;


public class ChanceNode extends Node{

    private static ArrayList <Node> nodePossible;
    private static int [] proba= {6,3};
    //private static ArrayList<Integer> proba ;

    public ChanceNode(String nom, String description){
        super(nom, description);
        if (nodePossible == null) {
            nodePossible = new ArrayList<>();
            nodePossible.add(new ChooseNode("Interrogatoire", "Vous etes suspecté de complicité avec le prince. Repondez a cet interrogatoire de maniere a enlever tout soupcon ...", nodePossible));
            nodePossible.add(new InnerNode("Detente a la caserne", "Vous tombé sur une caserne et decidez de faire une pause pour décompresser"));
            // Ajoutez d'autres nœuds à la liste ici
        }
    }

    

    public ArrayList <Node> getNodePossible() {
		return nodePossible ;
	}

        public Node select() {
            Random random = new Random();
            int randomNum = random.nextInt(10); // Utilisez 9 car c'est la somme des probabilités (6 + 3)

            if (randomNum <=  proba[0]) {
                // Si le nombre aléatoire est inférieur à la première probabilité, sélectionnez le premier type de nœud
                return getNodePossible().get(0); // Par exemple, le premier nœud de la liste
            } else {
                // Sinon, sélectionnez le deuxième type de nœud
                return getNodePossible().get(1); // Par exemple, le deuxième nœud de la liste
            }
        }

}