package Representation;
import univers.Statistiques;
import univers.personnages.*;


public class TestNode extends Node{
	
	private Node successNode ;
	private Node failureNode ;
	private Statistiques statATester ;
	private int difficulteTest ;
	private int nombreReussiteNecessaire ;
	
	public TestNode(String nom, String description, boolean checkPoint) {
		super(nom, description, checkPoint);
	}

	public TestNode(String nom, String description, boolean checkPoint, Node successNode, Node failureNode, Statistiques statATester, int difficulteTest, int nombreReussiteNecessaire) {
		super(nom, description, checkPoint) ;
		this.successNode = successNode ;
		this.failureNode = failureNode ;
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

	public Node getSuccessNode() {
		return successNode;
	}

	public void setSuccessNode(Node successNode) {
		this.successNode = successNode;
	}

	public Node getFailureNode() {
		return failureNode;
	}

	public void setFailureNode(Node failureNode) {
		this.failureNode = failureNode;
	}
	
	public void diplay() {
		int totalReussite = 0 ;
		for (int i = 0 ; i <= PersonnageCombattant.getGroupeJoueur().size() ; i++ ) {
			if (PersonnageCombattant.getGroupeJoueur().get(i).testStat(this.getDifficulteTest(), this.getStatATester())) {
				totalReussite++ ;
			}
		}
		
		// Voir avec interface de jeu mais quelque chose pour afficher la description 
		
		if (totalReussite >= this.getNombreReussiteNecessaire()) {
			this.getSuccessNode().display(); 
		} else {
			this.getFailureNode().display();
		}
	}

	@Override
	public Node goNext() {
		return null;
	}
}
