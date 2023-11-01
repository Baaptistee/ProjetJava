/**
 * The ChooseNode class represents a node for making a choice among different options.
 * It extends the Node class.
 */


 package Representation;

 import java.util.ArrayList;

public class ChooseNode extends Node {
	
	private  ArrayList <Node> options; // An array containing the different available options for the choice



	/**
     * Constructor for the ChooseNode class.
     * @param name The name of the choice node.
     * @param description The description of the choice node.
     * @param options The available options for the choice.
     */

	public ChooseNode(String nom, String description, ArrayList <Node> options){
		super(nom, description) ; // Call to the superclass constructor
		this.options = options ; 
	}
	
	
	 /**
     * Get the list of available options for the choice.
     * @return The list of options.
     */

	public ArrayList <Node> getOptions() {
		return options ;
	}

	 /**
     * Add an option to the list of available options.
     * @param additionalOption The option to add.
     */

	public void addOption(Node optionSupp) {
		getOptions().add(optionSupp);
	}

	/**
     * Remove an option from the list of available options.
     * @param removedOption The option to remove.
     */

	public void suppOption(Node suppOption) {
		int index=getOptions().indexOf(suppOption);
		options.remove(index);
	}
	
	 /**
     * Overrides the display method to display the information of the choice node.
     */
    
	@Override 
	public void display() {
		super.display();

    }

	


	/**
     * Main method for testing the ChooseNode class.
     */
	 public static void main(String[] args) {
		// Creating some nodes for options
		ArrayList <Node> options= new ArrayList<>();
		InnerNode test = new InnerNode("Y", "<html> L'histoire se déroule dans un royaume médiéval,/ où le prince héritier, un homme bien-aimé du peuple,/ est soudainement suspecté d'avoir assassiné le roi, son propre père,/ afin de s'emparer de la couronne./Malgré son innocence, les preuves semblent accablantes, et il est contraint de fuir pour échapper à la pendaison.", true) ; // balise html a revoir            		
		InnerNode test1 = new InnerNode("N", "<html> A la prochaine alors", true) ; // balise html a revoir            		
		InnerNode test2 = new InnerNode("N", "<html> Le prince se cache dans un village voisin,/ espérant rassembler des éléments pour prouver son innocence et rétablir son nom./ Ses amis loyaux, le soigneur compatissant, le chevalier courageux et le magicien astucieux,/ décident de l'aider en menant leur propre enquête pour découvrir la vérité qui le disculpera.", true) ; // balise html a revoir            		
		InnerNode test3 = new InnerNode("N", "<html> En tant qu'un de ces amis,/ le joueur se retrouve plongé au cœur d'une enquête complexe et dangereuse./ Vous devrez chercher des indices,/ interroger des témoins et déjouer les complots qui visent à incriminer le prince./Il faudra parfois se battre pour défendre vos amis/ des adversaires déterminés à garder le secret./ En chemin,/ vous devrez également surmonter des épreuves aléatoires pour progresser dans votre quête.", true) ; // balise html a revoir            		
		InnerNode test4 = new InnerNode("N", "<html> Votre mission sera de prendre les bonnes decisions/ pour rassembler suffisamment de preuves et prouver ou pas /l'innocence du prince et identifier le véritable coupable/ derrière le meurtre du roi./ Le destin du royaume repose entre vos mains./ Vous vous devrez faire preuve de courage,/ de perspicacité et de loyauté/ pour résoudre le mystère de la couronne perdue.", true) ; // balise html a revoir            		
		InnerNode test5 = new InnerNode("N", "<html>Il s'agit d'un jeux qui controlera tous les personnages/ Cependant, il faudra neamoins choisir un personnage qui te suivra tout le long du jeux./Voici une breve presentation des personnages(Suivant).", true) ; // balise html a revoir         
		InnerNode test6 = new InnerNode("N", "<html> <span><b>Le Magicien Mystique</b></span>/Le Magicien Mystique est le gardien des secrets anciens et des pouvoirs mystérieux./ Il est habillé de robes sombres et ornementées,/son regard est empreint de sagesse./ Avec son bâton magique étincelant,/ il maîtrise les éléments et peut invoquer des sorts envoûtants pour résoudre les énigmes les plus complexes./ Le Magicien est le choix idéal pour ceux qui recherchent la magie/ et la puissance spirituelle pour naviguer dans un monde/ rempli de mystères et de défis.", true) ; // balise html a revoir     
		ChanceNode test7 = new ChanceNode("vsfvh", "yegfj");       		   		
		options.add(test);
		options.add(test1);

		ChooseNode Beginning = new ChooseNode("Decouverte", "<html>Bienvenu dans qui a tué le roi./ etes vous pret a lancer une nouvelle partie dans ce jeux ou vous etes le hero?",options);
		Beginning.display();
		test.setNextNode(test2);
		test2.setNextNode(test3);
		test3.setNextNode(test4);
		test4.setNextNode(test5);
		test5.setNextNode(test6);
		test6.setNextNode(test7.select());
		//TerminalNode gameOver = new TerminalNode("Game Over" , "<html> Tu viens de mourir grosse merde, veux tu reprendre au check point ou rage quit ?") ;
		
		//InnerNode test2 = new InnerNode("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;

		//FightNode test3 = new FightNode("Combat", "C'est la guerre");
 		
		// Configuring next nodes
		//test2.setNextNode(gameOver) ;
		//test.setNextNode(test2) ;
		//test3.setNextNode(test3);
 		
		// Creating a list of options
		/*ArrayList <Node> options1= new ArrayList<>();
		options1.add(test);
		options1.add(test2);
		options1.add(gameOver);
		options1.add(test3);*/
 		
		// Creating a choice node
		//ChooseNode testChoix = new ChooseNode("test", "<html> tu dois choisir entre les choix suivants : ", options) ;
 		
		// Displaying the choice node
		//testChoix.display() ;
     }
    
}

