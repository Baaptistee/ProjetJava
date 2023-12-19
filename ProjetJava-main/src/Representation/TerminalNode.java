package Representation;

public class TerminalNode extends Node {
	
	public TerminalNode(String nom, String description,String imageName) throws IllegalArgumentException {
		
		super(nom, description, imageName) ;
		
	}	
	
	@Override
	public void goNext() {

		// méthode vide pour l'instant mais qui sera utilisée plus tard quand implémentation de checkpoint et de 
		// possibilité de recommencer 
	}
	@Override
	public String toString() {
		return "TerminalNode:"+super.toString();
	}
	
} 
