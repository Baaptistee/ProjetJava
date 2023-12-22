package univers.personnages.personnagesGroupe;


//import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
//import univers.armes.Weapon;
import univers.competences.*;
import univers.personnages.PersoGroupe;

public class Mage extends PersoGroupe {
	
	private static Mage instance ;
	
	/** 
	 * Le constructeur en privé car c'est une classe singleton 
	 * @param nom le nom du personnage 
	 * @param description la description du personnage 
	 * @param dexterite la dexterité de base du personnage 
	 * @param strengh la force du personnage 
	 * @param intelligence l'intelligence du perso
	 * @param endurance l'endurance du perso
	 * @param speed la vitesse du perso 
	 * @param maxMana le mana Maximum du personnage 
	 * @param maxLifePoints les Points de vie maximum du perso 
	 * @param competences La liste des compétences de base du perso 
	 * @param faiblesses les faiblesses du perso 
	 * @param resistances les resistances du perso 
	 */
	private Mage (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances) ;
	}
	
	/**
	 * Un getter pour l'instance Mage 
	 * @return l'instance Mage
	 */
	public static Mage getMage() {
		if (instance == null) {
			ArrayList<CompetencesActives> competence = new ArrayList<CompetencesActives>() ;
			CompetencesActives c1 = new CompetenceDammage("Attaque de base", "Une attaque de base avec l'arme", 0, 100, 5, 1, Eleme.NONE, false, true) ;
			CompetencesActives c2 = new CompetenceDammage("Attaque puissante", "une attaque puissante", 5, 100, 10, 1, Eleme.NONE, false, true) ;
			competence.add(c2) ;
			competence.add(c1) ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			instance = new Mage("Mage", "Description du Chevalier", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances) ;
			instance.setImage("image/MC_Mage.png");
		}
		return instance ;
	}

	/**
	 * Fonction pour recommencer un nouveau mage en cas de nouvelle partie par exemple
	 */
	public static void newMage(){
		instance = null ;
	}

	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return "Mage " + super.toString();
	}

	/**
	 * La méthode equals pour vérifier si l'objet comparé est égal
	 * @param obj l'objet comparé
	 * @return si l'objet est le même ou pas 
	 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			else
				return false ;
		}
		
	/**
	 * La fonction pour quand le personnage gagne un niveau 
	 */
	public String gainNiveau() {
		Random random = new Random() ;
		this.setLevel(this.getLevel()+1);
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getSpeed(), e = this.getBaseEndurance() ;
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;
		
		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			CompetenceDammage bouleDeFeu = new CompetenceDammage("Boule de feu", "Une petite boule de feu infligeant quelques dégâts", 5, 95, 8, 1, Eleme.FEU, false, false);
			this.getCompetences().add(bouleDeFeu) ;
			t += "/Il apprend la compétence active : Boule de feu !" ;
		}
		
		return t ;
	}
	
}