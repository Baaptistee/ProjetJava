package univers.personnages.personnagesGroupe;

import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.armes.Weapon;
import univers.competences.*;
import univers.personnages.PersoGroupe;

/**
 * Une classe Singleton pour le Chevalier du groupe 
 */
public class Chevalier extends PersoGroupe{
	
	private static Chevalier instance ;
	
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
	private Chevalier  (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances) ;
	}
	
	/**
	 * Un getter pour l'instance Chevalier 
	 * @return l'instance chevalier
	 */
	public static Chevalier getChevalier() {
		if (instance == null) {
			ArrayList<CompetencesActives> competence = new ArrayList<CompetencesActives>() ;
			CompetencesActives c1 = new CompetenceDammage("Coup d'épée faible", "Une attaque de base avec l'arme", 0, 100, 5, 1, Eleme.NONE, false, true) ;
			CompetencesActives c2 = new CompetenceDammage("Coup d'épée puissant", "une attaque puissante avec l'arme", 5, 100, 10, 1, Eleme.NONE, false, true) ;
			competence.add(c2) ;
			competence.add(c1) ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			instance = new Chevalier("Chevalier", "Description du Chevalier", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances) ;
			instance.setImage("image/chevalier.png");
			Weapon petiteEpee = new Weapon(2, 100,"Petite Épée", "Une épée solide mais vétuste.", 3, 0, 1, 1, 0);

			instance.setWeapon(petiteEpee);
		}
		return instance ;
	}

	/**
	 * Fonction pour recommencer un nouveau chevalier en cas de nouvelle partie par exemple
	 */
	public static void newChevalier(){
		instance = null ;
	}
	
	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return "Chevalier " + super.toString();
	}

	
	/**
	 * La fonction pour quand le personnage gagne un niveau 
	 */
	public String gainNiveau() {
		Random random = new Random() ;
		this.setLevel(this.getLevel() +1);
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getBaseSpeed(), e = this.getBaseEndurance() ;
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;

		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel() == 2) {
			CompetenceDammage tailladeLarge = new CompetenceDammage("Taillade Large", "Une grande taillade qui inflige de légers dégâts à tous les ennemis. ", 10, 80, 5, 1, Eleme.NONE, true, true) ;
			this.getCompetences().add(tailladeLarge) ;
			t += "/Il apprend la compétence active : Taillade Large !" ;
		}
		if (this.getLevel() == 3) {
			CompetenceDammage epeeFeu = new CompetenceDammage("Lame de feu", "Une attaque qui inflige de légers dégâts de feu à un ennemi", 3, 100, 7, 1, Eleme.FEU, false, true) ;
			this.getCompetences().add(epeeFeu) ;
			t += "/Il apprend la compétence active : Lame de feu !" ;
		}
		if (this.getLevel()==4){
			CompetenceDammage acharnement = new CompetenceDammage("Acharnement", "Une attaque qui inflige de légers à un ennemi 3 fois !", 6, 80, 4, 3, Eleme.NONE, false, true) ;
			this.getCompetences().add(acharnement) ;
			t += "/Il apprend la compétence active : Acharnement !" ;
		}
		if (this.getLevel() == 5) {
			CompetenceDammage AttaqueMort = new CompetenceDammage("Épée ultime", "Une grande taillade qui inflige de légers dégâts à tous les ennemis. ", 15, 90, 15, 1, Eleme.NONE, true, true) ;
			this.getCompetences().add(AttaqueMort) ;
			t += "/Il apprend la compétence active : Épée ultime !" ;
		}
		return t ;
	}

	// qu'une seule vérification dans le equals car classe est un singleton
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
	
	

}
