package univers.personnages;

import java.util.Random;

public class Prince extends PersoGroupe {

	private static Prince instance ;
	
	private Prince(String nom, String description, int dexterite, int force, int intelligence, int endurance, int vie){
		super(nom, description, dexterite, force, intelligence, endurance, vie) ;
	}
	
	public static Prince getPrince() {
		if (instance == null) {
			instance = new Prince("Nom du Prince", "Description du Prince", 5, 5, 5, 5, 30) ;
		}
		return instance ; 
	}
	
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
