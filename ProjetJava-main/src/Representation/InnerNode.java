package Representation;


public class InnerNode extends Node {

    public InnerNode(String nom, String description) {
		super(nom,description);
	}

    public InnerNode(String nom, String description, boolean checkPoint) {

        super(nom,description,checkPoint);
    }
    
    public static void main(String[] args) {
		
		InnerNode test = new InnerNode("Node test", "<html> vous êtes un jeune prince/ BLABLABLA Vous avez assassiné le roi etc... ") ; // balise html a revoir
		InnerNode test2 = new InnerNode("Node next", "<html> vous devez prouver votre innocence et vous battre pour vous") ;
		test.setNextNode(test2) ;
			    
	    test.display() ;
		
		
	}
	
}
