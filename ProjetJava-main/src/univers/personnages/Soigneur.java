package univers.personnages;

import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.armes.WeaponType;
import univers.competences.*;

public class Soigneur extends PersoGroupe{
	
	private static Soigneur instance ;
	
	private Soigneur  (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<Competences> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<WeaponType> armePossible){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances, armePossible) ;
	}
	
	/*
	public static Soigneur getSoigneur() {
		if (instance == null) {
			instance = new Soigneur("Nom du Soigneur", "Description du soigneur", 5, 5, 5, 5, 5, 30, 40) ;
		}
		return instance ;
	}*/
	
	public String gainNiveau() {
		Random random = new Random() ;
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity() ;
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		
		String d = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite :" + c + " -> " + this.getBaseDexterity() ;
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			//this.getCompetences().add(SoinRapide.getSoinRapide()) ;
			d += "/Il apprend la compétence active : Coup Soigneur !" ;
		}
		return d ;
	}
	
	

}
