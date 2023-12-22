/**
 * La Classe chanceNode est pour des nodes dont le node suivant sera déterminé de manière aléatoire 
 *
 * @see InnerNode
 */
package Representation;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class ChanceNode extends InnerNode {

    /**
     * les probabilités pour chaque option du node 
     */
    private ArrayList<Integer> probability;

    /**
     * Constructeur de la classe 
     * @param nom Le nom du chanceNode 
     * @param description La description du chanceNode 
     * @param options Les différentes options du chanceNode
     * @param imageName Le lien de l'image de fond
     * @param probability la probabilité de chacune des options
     */
    public ChanceNode(String nom, String description, ArrayList<Node> options, String imageName, ArrayList<Integer> probability) {
        super(nom, description, imageName, options);
        this.probability = probability;
        probaOptionBienInstanciees();
    }

    /**
     * Un autre constructeur
     * @param nom le nom du chanceNode
     * @param description La description du constructeur
     * @param imageName le lien de l'image de fond
     * @param probability les probabilités associées à chacune des options
     */
    public ChanceNode(String nom, String description,String imageName, ArrayList<Integer> probability) {
        super(nom, description, imageName);
        this.probability = probability;
    }

    /**
     * Un autre constructeur 
     *
     * @param nom le nom du chanceNode
     * @param description la description du ChanceNode.
     * @param probability la probabilité de chaque node possible
     */
    public ChanceNode(String nom, String description, ArrayList<Integer> probability) {
        super(nom, description);
        this.probability = probability;
    }

    /**
     * un autre constructeur 
     *
     * @param description  la description du node 
     * @param probability  la probabilité de chacune des options
     */
    public ChanceNode(String description, ArrayList<Integer> probability) {
        super("Node" + Node.getTotalNode() + 1, description);
        this.probability = probability;
    }

    /**
     * un getter pour les probabilités 
     *
     * @return la arrayList avec nos probabilités 
     */
    public ArrayList<Integer> getProbability() {
        return probability;
    }

    /**
     * un setter pour les proabbilités 
     * @param probability la nouvelle liste de probabilités
     */
    public void setProbability(ArrayList<Integer> probability) {
        if(probability.isEmpty()){
            throw new IllegalStateException("La liste des probabilité est null");
        }
        this.probability = probability;
        probaOptionBienInstanciees();

    }

    /**
     * Sélectionne node à l'aide de la librairie randomé
     *
     * @return Le node sélectionné
     */
    public Node select() {
        if (this.getOptions().isEmpty()) {
            throw new IllegalStateException("La liste des options ne peut pas être vide");
        }
        probaOptionBienInstanciees();
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
     * une fonction pour vérifier que les proba et les options sont bien instanciées (de même taille)
     */
    public void probaOptionBienInstanciees(){
        if (probability.size()!=this.getOptions().size()){
            throw new IllegalStateException("Pas le même nombre de probabilités que d'options !");
        }
    }

    /**
     * La fonction pour retourner le node suivant
     * @return le node suivant 
     */
    public Node goNext() {
        Node selectedNode = this.select();
        selectedNode.setFormerNode(this);
        return selectedNode;
    }

    /**
     * un override de la méthode toString
     *
     * @returnle string qui va représenter le chanceNode
     */
    @Override
    public String toString() {
        return "ChanceNode: " + super.toString();
    }

    /**
     *la méthode équals pour le chanceNode 
     *
     * @param obj L'objet auquel il est comparé
     * @return Vrai si ce sont les mêmes objets et faux sinon
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