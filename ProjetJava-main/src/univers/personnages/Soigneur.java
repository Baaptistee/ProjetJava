package univers.personnages;

import java.util.Random;
import univers.competences.*;

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
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity() ;
		// le gain de statistique se fait aléatoirement 
		setStrength(getBaseStrength() + random.nextInt(3)) ;
		setIntelligence(getBaseIntelligence() + random.nextInt(1)) ;
		setDexterity(getBaseDexterity() + random.nextInt(2)) ;
		
		String d = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite :" + c + " -> " + this.getBaseDexterity() ;
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			this.getCompetences().add(SoinRapide.getSoinRapide()) ;
			d += "/Il apprend la compétence active : Coup Soigneur !" ;
		}
		return d ;
	}
	
	

}
