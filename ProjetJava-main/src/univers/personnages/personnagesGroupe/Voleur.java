package univers.personnages.personnagesGroupe;


import java.util.ArrayList;
import java.util.Random;

import univers.Eleme;
import univers.armes.Weapon;
//import univers.armes.Weapon;
import univers.competences.*;
import univers.personnages.PersoGroupe;

public class Voleur extends PersoGroupe{
	/** the class is a singleton so we have the instance of the class 
	 * 
	 */
	private static Voleur instance ;
	
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
	private Voleur (String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances){
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, competences, faiblesses, resistances) ;
	}
	
	/**
	 * Un getter pour l'instance Voleur 
	 * @return l'instance Voleur
	 */
	public static Voleur getVoleur() {
		if (instance == null) {
			ArrayList<CompetencesActives> competence = new ArrayList<CompetencesActives>() ;
			CompetencesActives c1 = new CompetenceDammage("Lancer de Dague", "Une attaque de base avec la dague", 0, 100, 5, 1, Eleme.NONE, false, true) ;
			CompetencesActives c2 = new CompetenceDammage("Coups de Poignard", "Frappe de 3 coups de Poignard peu précis la cible", 15, 50, 10, 3, Eleme.NONE, false, true) ;
			competence.add(c2) ;
			competence.add(c1) ;
			ArrayList<Eleme> faiblesses = new ArrayList<Eleme>() ;
			ArrayList<Eleme> resistances = new ArrayList<Eleme>() ;
			instance = new Voleur("Voleur", "Description du voleur", 5, 5, 5, 5, 5, 30, 40, competence, faiblesses, resistances) ;
			instance.setImage("image/voleur.png");
			Weapon petiteEpee = new Weapon(2, 100,"Petite Dague", "Une dague solide mais vétuste.", 2, 1, 3, 0, 4);
			instance.setWeapon(petiteEpee);

		}
		return instance ;
	}
	/**
	 * Fonction pour recommencer un nouveau Voleur en cas de nouvelle partie par exemple
	 */
	public static void newVoleur(){
		instance = null ;
	}

	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return "Voleur " + super.toString();
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
		this.setLevel(getLevel()+1);
		int a = this.getBaseStrength(), b = this.getBaseIntelligence(), c = this.getBaseDexterity(), d = this.getBaseSpeed(), e = this.getBaseEndurance(), f = this.getMaxLifePoints(),  g = this.getMaxMana();
		// le gain de statistique se fait aléatoirement 
		this.setStrength(getBaseStrength() + 1 + random.nextInt(2)) ;
		setIntelligence(getBaseIntelligence() + 1 + random.nextInt(3)) ;
		setDexterity(getBaseDexterity() + 1 + random.nextInt(1)) ;
		setSpeed(getBaseSpeed() + 1 + random.nextInt(1)) ; 
		setEndurance(getBaseEndurance() + 1 + random.nextInt(1)) ;
		setMaxLifePoints((f)+3+random.nextInt(5));
		setMaxMana(g+2+random.nextInt(3));
		
		String t = this.getName() + " passe niveau " + this.getLevel() + "! / Force : " + a + " -> " + this.getBaseStrength() + "/Intelligence : " + b + " -> " + this.getBaseIntelligence() + "/Dexterite : " + c + " -> " + this.getBaseDexterity() + "/Vitesse : " + d + " -> " + this.getBaseSpeed() + "/Endurance : " + e + " -> " + this.getBaseEndurance()+ "/PV Max : "+f+" -> "+this.getMaxLifePoints()+"/PM Max : "+g+" -> "+this.getMaxMana();
		
		// apprentissage de nouvelles compétences régulièrement en cas de gain de niveau 
		if (this.getLevel()==2){
			CompetenceDammage pluieDeFleches = new CompetenceDammage("Pluie de Flèche", "Lance une flèche sur chaque ennemi 2 fois, mais avec une précision réduite.", 10, 60, 8, 2, Eleme.NONE, false, true);
			this.getCompetences().add(pluieDeFleches) ;
			t += "/Il apprend la compétence active : Pluie de Flèches ! /" ;
		}
		if (this.getLevel() == 3) {
			CompetenceDammage lancerDeCouteaux = new CompetenceDammage("Lancer de couteaux", "Lance un couteau sur un ennemi 3 fois, mais avec une précision réduite.", 5, 70, 4, 3, Eleme.NONE, false, true);
			this.getCompetences().add(lancerDeCouteaux) ;
			t += "/Il apprend la compétence active : Lancer de couteaux !/" ;
		}
		if (this.getLevel() == 4) {
			CompetenceSoin Tchatcheur = new CompetenceSoin("Premiers Secours", "Soigne moyennement un allié.", 8, 10, false);
			this.getCompetences().add(Tchatcheur) ;
			t += "/Il apprend la compétence active : Premiers Secours !/" ;
		}
		if (this.getLevel() == 5) {
			CompetenceDammage lancerDeCouteaux = new CompetenceDammage("Déchaînement de dagues", "Lance une dague sur chaque ennemi 3 fois avec une précision réduite", 25, 60, 10, 3, Eleme.NONE, false, true);
			this.getCompetences().add(lancerDeCouteaux) ;
			t += "/Il apprend la compétence active : Déchaînement de dagues !/" ;
		}
		
		return t ;
	}
	
}
