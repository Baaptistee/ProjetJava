package Representation;

import java.util.ArrayList;
/** 
 * une classe pour un Node n'ayant qu'un seul Node possible, il sert de node de transition entre par exemple 1 chanceNode et un FIghtNode 
 */
public class TextNode extends InnerNode {

	public TextNode(String nom, String description,String imageName, boolean checkPoint, ArrayList<Node> option) {
		super(nom, description,imageName, checkPoint, option);
	}

	public TextNode(String nom, String description,String imageName, boolean checkPoint) {
		super(nom, description,imageName, checkPoint) ;
	}
	
	
	public void goNext() {
		this.getOptions().get(0).setFormerNode(this);
		this.getOptions().get(0).display();
	}
	@Override
	public String toString() {
		return "TextNode:"+super.toString();
	}

}
