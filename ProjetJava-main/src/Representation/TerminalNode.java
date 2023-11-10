package Representation;

public class TerminalNode extends Node {
	
	public TerminalNode(String nom, String description) {
		
		super(nom, description) ;
		
	}	
	
	@Override
	public String toString() {
		return "TerminalNode:"+super.toString();
	}
	
	@Override
	public void goNext() {
		// méthode vide pour l'instant mais qui sera utilisée plus tard quand implémentation de checkpoint et de 
		// possibilité de recommencer 
	}
	
} 
