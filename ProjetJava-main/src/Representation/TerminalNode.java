package Representation;

public class TerminalNode extends Node {
	
	public TerminalNode(String nom, String description,String imageName) {
		
		super(nom, description, imageName) ;
		
	}	
	@Override
	public void goNext() {

		
	}
	@Override
	public String toString() {
		return "TerminalNode:"+super.toString();
	}
	
} 
