package univers.personnages;

import java.util.Random;

public class Magicien extends PersoGroupe {

	private static Magicien instance ;
	
	private Magicien(String nom, String description, int dexterite, int force, int intelligence, int endurance, int vie){
		super(nom, description, dexterite, force, intelligence, endurance, vie) ;
	}
	
	public static Magicien getMagicien() {
		if (instance == null) {
			instance = new Magicien("Nom du Magicien", "Description du magicien", 5, 5, 5, 5, 30) ;
		}
		return instance ;
	}
	
	
	public String gainNiveau() {
		Random random = new Random() ;
		int a = this.getStrength(), b = this.getIntelligence(), c = this.getDexterity() ;
		// le gain de statistique se fait aléatoirement 
		setStrength(getStrength() + random.nextInt(1)) ;
		setIntelligence(getIntelligence() + random.nextInt(3)) ;
		setDexterity(getDexterity() + random.nextInt(2)) ;
		
		String d = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getStrength() + "/Intelligence : " + b + " -> " + this.getIntelligence() + "/Dexterite :" + c + " -> " + this.getDexterity() ;
		
		return d ;
	}
	
}
	
	

