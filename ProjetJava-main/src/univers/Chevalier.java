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
	    
	public static void main(String[] args) {
		
	

		        JFrame frame = new JFrame("Exemple de JLayeredPane");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setSize(400, 400);

		        JLayeredPane layeredPane = new JLayeredPane();
		        frame.add(layeredPane);

		        JButton button1 = new JButton("Bouton 1");
		        button1.setBounds(50, 50, 100, 30); // Position et taille du bouton 1
		        layeredPane.add(button1, JLayeredPane.DEFAULT_LAYER); // Ajout du bouton 1 à la couche par défaut

		        JButton button2 = new JButton("Bouton 2");
		        button2.setBounds(100, 100, 100, 30); // Position et taille du bouton 2
		        layeredPane.add(button2, JLayeredPane.PALETTE_LAYER); // Ajout du bouton 2 à une couche supérieure

		        frame.setVisible(true);
		    }
		

	

	}

