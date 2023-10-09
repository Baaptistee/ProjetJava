package univers.personnages;

import java.awt.* ;
import java.util.Random;

import javax.swing.*;

public class Chevalier extends PersoGroupe{
	
	private static Chevalier instance ;
	
	// Constructeur de la classe en privée car singleton
	private Chevalier(String nom, String description, int dexterite, int strength, int intelligence, int endurance, int vie){
		super(nom, description, dexterite, strength, intelligence, endurance, vie) ;
	}
	
	// getter de la seule instance de la classe 
	public static Chevalier getChevalier() {
		// l'instance est crée la première fois que le getter est appelé pour optimiser la mémoire 
		if (instance == null) {
			instance = new Chevalier("Nom du Chevalier", "Description du Chevalier", 5, 5, 5, 5, 30) ;
		}
		return instance ; 
	}
	
	
	// méthode à appeler avec la future "afficheTexte" elle retourne à la fois le texte à mettre dans le popUP et change les valeurs des statistiques du chevalier 
	public String gainNiveau() {
		Random random = new Random() ;
		int a = this.getStrength(), b = this.getIntelligence(), c = this.getDexterity() ;
		// le gain de statistique se fait aléatoirement 
		setStrength(getStrength() + random.nextInt(3)) ;
		setIntelligence(getIntelligence() + random.nextInt(1)) ;
		setDexterity(getDexterity() + random.nextInt(2)) ;
		
		String d = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getStrength() + "/Intelligence : " + b + " -> " + this.getIntelligence() + "/Dexterite :" + c + " -> " + this.getDexterity() ;
		
		return d ;
	}


	    
	}

