package univers;

import java.awt.* ;
import java.util.Random;

import javax.swing.*;

public class Chevalier extends PersoGroupe{

	public Chevalier(String nom, String description, int dexterite, int force, int intelligence, int vie){
		super(nom, description, dexterite, force, intelligence, vie) ;
	}
	
	@Override 
	public void gainNiveau() {
		Random random = new Random() ;
		setForce(getForce() + random.nextInt(3)) ;
		setIntelligence(getIntelligence() + random.nextInt(1)) ;
		setDexterite(getDexterite() + random.nextInt(2)) ;	
	}


	    
	}

