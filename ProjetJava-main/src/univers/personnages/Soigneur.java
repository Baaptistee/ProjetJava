package univers.personnages;

import java.util.Random;

public class Soigneur extends PersoGroupe{
	
	private static Soigneur instance ;
	
	private Soigneur  (String nom, String description, int dexterite, int force, int intelligence, int endurance, int vie){
		super(nom, description, dexterite, force, intelligence, endurance, vie) ;
	}
	
	public static Soigneur getSoigneur() {
		if (instance == null) {
			instance = new Soigneur("Nom du Soigneur", "Description du soigneur", 5, 5, 5, 5, 40) ;
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
