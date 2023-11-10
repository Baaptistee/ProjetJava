package Representation;
import java.util.ArrayList;

import univers.Statistiques;
import univers.personnages.*;


public class TestNode extends InnerNode{
	
	private Statistiques statATester ;
	private int difficulteTest ;
	private int nombreReussiteNecessaire ;
	
	

	public TestNode(String nom, String description, boolean checkPoint, ArrayList<Node> options, Statistiques statATester, int difficulteTest, int nombreReussiteNecessaire) {
		super(nom, description, checkPoint, options) ;
		this.difficulteTest = difficulteTest ;
		this.statATester = statATester ;
		this.nombreReussiteNecessaire = nombreReussiteNecessaire ;
	}
	
	public int getNombreReussiteNecessaire() {
		return nombreReussiteNecessaire;
	}

	public void setNombreReussiteNecessaire(int nombreReussiteNecessaire) {
		this.nombreReussiteNecessaire = nombreReussiteNecessaire;
	}

	public Statistiques getStatATester() {
		return statATester;
	}

	public void setStatATester(Statistiques statATester) {
		this.statATester = statATester;
	}

	public int getDifficulteTest() {
		return difficulteTest;
	}

	public void setDifficulteTest(int difficulteTest) {
		this.difficulteTest = difficulteTest;
	}
	
	public Node select() {
		int totalReussite = 0 ;
		for (int i = 0 ; i <= Game.getGroupeJoueur().size() ; i++ ) {
			if (Game.getGroupeJoueur().get(i).testStat(this.getDifficulteTest(), this.getStatATester())) {
				totalReussite++ ;
			}
		}
			// Voir avec interface de jeu mais quelque chose pour afficher la description 
		
		if (totalReussite >= this.getNombreReussiteNecessaire()) {
			// par convention, on aura le Node de succès en première position et le Node d'échec en seconde position 
			return this.getOptions().get(0) ;
		} else {
			return this.getOptions().get(1) ;
		}
	}
	
	@Override
	public void goNext() {
			Node a = this.select() ;
			a.setFormerNode(this);
			a.display();
			
	}

}