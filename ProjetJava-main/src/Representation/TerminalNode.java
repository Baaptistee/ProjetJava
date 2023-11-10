package Representation;

public class TerminalNode extends Node {
	
	public TerminalNode(String nom, String description) {
		
		super(nom, description) ;
		
	}	
	@Override
	public void goNext() {

		
	}
	@Override
	public String toString() {
		return "TerminalNode:"+super.toString();
	}
	
} 
