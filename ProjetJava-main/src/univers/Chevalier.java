package univers;

import java.awt.* ;

import javax.swing.*;

public class Chevalier extends PersoGroupe{

	public Chevalier(String nom, String description, int dexterite, int force, int intelligence, int vie){
		super(nom, description, dexterite, force, intelligence, vie) ;
	}
	
	@Override 
	public void gainNiveau() {
	}


	    private static JPanel createColoredPanel(Color color, int x, int y, int width, int height) {
	        JPanel panel = new JPanel();
	        panel.setBackground(color);
	        panel.setBounds(x, y, width, height);
	        return panel;
	    
	}

	}

