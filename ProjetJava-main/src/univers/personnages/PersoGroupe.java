package univers.personnages;
import univers.competences.*;
import univers.Eleme;
import univers.armes.*;
import java.util.* ;
import Representation.Game;

/**
 * Une classe abstraite pour représenter les personnages du groupe 
 */
public abstract class PersoGroupe extends PersonnageCombattant{
	
	private int experience ;
	private Weapon weapon ;
	private ArrayList<CompetencesActives> competences ;
	
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
	public PersoGroupe(String nom, String description, int dexterite, int strengh, int intelligence, int endurance, int speed, int maxMana, int maxLifePoints, ArrayList<CompetencesActives> competences, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances) {
		super(nom, description, dexterite, strengh, intelligence, endurance, speed, maxMana, maxLifePoints, faiblesses, resistances) ;
		this.experience = 0 ;
		
		if (competences==null){
			this.competences=new ArrayList<>();
		} else this.competences = competences ;
	}
	
	/**
	 * Un getter pour l'expérience 
	 * @return l'expérience du perso 
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Un setter pour l'expérience 
	 * @param experience l'expérience du perso
	 */
	public void setExperience(int experience) {
			if (experience < 0){
				throw new IllegalArgumentException("Experience ne peut être inferieure à zéro") ;
			} else this.experience = experience;
	}
	
	/**
	 * Un getter pour l'arme du perso 
	 * @return l'arme du perso 
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * Un setter pour l'arme 
	 * @param arme la nouvelle arme 
	 */
	public void setWeapon(Weapon arme){
		this.weapon=arme ;
	}
	
	
	/**
	 * Un getter pour les compétences 
	 * @return les compétences 
	 */
	public ArrayList<CompetencesActives> getCompetences() {
		return this.competences;
	}

	/**
	 * Un setter pour les compétences des personnages 
	 * @param competences les nouvelles compétences 
	 */
	public void setCompetences(ArrayList<CompetencesActives> competences) {
		this.competences = competences;
	}

	/**
	 * Un getter pour l'intelligence avec le bonus de l'arme 
	 * @return l'intelligence avec le bonus de l'arme 
	 */
	@Override 
	public int getIntelligence() {
		if (weapon != null) {
			return (this.getWeapon().getBonusIntelligence() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	
	/**
	 * Un getter pour la force avec le bonus de l'arme 
	 * @return la force avec le bonus de l'arme 
	 */
	@Override 
	public int getStrength() {
		if (weapon != null) {
			return (this.getWeapon().getBonusStrength() + super.getStrength()) ;
		} else {
			return super.getStrength() ;
		}
	}
	
	/**
	 * Un getter pour la dextérité avec le bonus de l'arme 
	 * @return la dextérité avec le bonus de l'arme 
	 */
	@Override 
	public int getDexterity() {
		if (weapon != null) {
			return (this.getWeapon().getBonusDexterity() + super.getDexterity()) ;
		} else {
			return super.getDexterity() ;
		}
	}
	/**
	 * Un getter pour l'endurance avec le bonus de l'arme 
	 * @return l'endurance avec le bonus de l'arme 
	 */
	@Override 
	public int getEndurance() {
		if (weapon != null) {
			return (this.getWeapon().getBonusIntelligence() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	
	/**
	 * Un getter pour la vitesse  avec le bonus de l'arme 
	 * @return la vitesse avec le bonus de l'arme 
	 */
	@Override
	public int getSpeed() {
		if (weapon != null) {
			return (this.getWeapon().getBonusSpeed() + super.getIntelligence()) ;
		} else {
			return super.getIntelligence() ;
		}
	}
	
	/**
	 * Un getter pour la vitesse de base 
	 * @return la vitesse de base 
	 */
	public int getBaseSpeed() {
		return super.getSpeed() ;
	}
	/**
	 * Un getter pour la force de base 
	 * @return la force de base 
	 */ 
	public int getBaseStrength() {
		return super.getStrength() ;
	}
	/**
	 * Un getter pour l'intelligence de base 
	 * @return l'intelligence de base 
	 */
	public int getBaseIntelligence() {
		return super.getIntelligence() ;
	}
	/**
	 * Un getter pour la dextérité de base 
	 * @return la dextérité de base 
	 */
	public int getBaseDexterity() {
		return super.getDexterity() ;
	}
	
	/**
	 * Un getter pour l'endurance de base 
	 * @return l'endurance de base 
	 */
	public int getBaseEndurance() {
		return super.getEndurance() ;
	}
	
	/**
	 * un getter pour le groupe du perso
	 * @return le groupe du perso
	 */
	public ArrayList<PersonnageCombattant> getGroupe() {
		return Game.getGame().getGroupeJoueur();
	}

	/**
	 * Méthode pour set le groupe du perso
	 * (inutile pour les personnages de groupe mais partagée avec les personnageCombattant)
	 * @param newGroup le nouveau groupe
	 */
	public void setGroupe(ArrayList<PersonnageCombattant> newGroup) {};


	/**
	 * une méthode pour obtenir le groupe encore en vie 
	 * @return le groupe encore en vie 
	 */
	public ArrayList<PersonnageCombattant> getGroupeVivant() {
		ArrayList<PersonnageCombattant> groupeVivant = new ArrayList<PersonnageCombattant>() ;
		for (int i = 0 ; i < this.getGroupe().size() ; i++){
			if (this.getGroupe().get(i).enVie()){
				groupeVivant.add(this.getGroupe().get(i)) ;
			}
		}
		return groupeVivant;
	}

	

	
	/**
	 * Une méthode pour faire gagner de l'xp à nos personnages 
	 * @param xp l'xp gagnée
	 * @return le texte à afficher si les personnages ont gagné de l'expérience 
	 */
	public String gainExperience(int xp) {
			if (xp<=0){
				throw new IllegalArgumentException("Expérience peut pas être inférieure à zéro") ;
			}
			String retour = "nope" ;
			//boolean retour = false ;
			experience += xp ; 
			// si il y a assez d'expérience 
			if (this.getExperience() >= this.getLevel()*10 + 90) {
				// on réinitialise l'expérience enlevant celle qui a servi au gain de niveau 
				this.setExperience(getExperience() - (getLevel()*10 + 90)) ;
				//On appelle la fonction gain de niveau 
				retour = this.gainNiveau() ;
			
			}
			return retour ;

	}

	/**
	 * Une fonction pour savoir si le personnage gagne un niveau
	 * @param xp l'xp gagnée 
	 * @return si le personnage gagne un niveau ou pas 
	 */
	public boolean isLevelUp(int xp){
		boolean retour = false ;
		if (this.getExperience() >= this.getLevel()*10 + 90) {
			retour = true ;
		}
		return retour ;
	}
	
	/**
	 * Une méthode pour le gain de niveau du personnage 
	 * @return le texte à afficher dans l'interface
	 */
	public abstract String gainNiveau() ;
	
	/**
	 * Une méthode pour convertir en string notre classe 
	 * @return le string du personnage 
	 */
	@Override
	public String toString() {
		return super.toString() + " [experience=" + experience + ", weapon=" + weapon + ", competences=" + competences
				+ "]";
	}
	/**
	 * La méthode equals pour vérifier si l'objet comparé est égal
	 * @param obj l'objet comparé
	 * @return si l'objet est le même ou pas 
	 */
	@Override
	    public boolean equals(Object obj) {
			if (this == obj) {
				return true ;
			} else if (obj.getClass() != this.getClass()) {
				return false ;
			} else {
				PersoGroupe perso = (PersoGroupe)obj ;
				if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getImageLien(), perso.getImageLien()) && Objects.equals(this.getPersoId(), perso.getPersoId()) && Objects.equals(this.getDexterity() , perso.getDexterity()) && Objects.equals(this.getStrength() , perso.getStrength()) && Objects.equals(this.getEndurance() , perso.getEndurance()) && Objects.equals(this.getFaiblesses() , perso.getFaiblesses()) && Objects.equals( this.getGroupe() , perso.getGroupe()) && Objects.equals(this.getIntelligence() , perso.getIntelligence()) && Objects.equals(this.getLevel() , perso.getLevel()) && Objects.equals(this.getLifePoints() , perso.getLifePoints()) && Objects.equals(this.getMana() , perso.getMana()) && Objects.equals(this.getMaxLifePoints() , perso.getMaxLifePoints()) && Objects.equals(this.getMaxMana(), perso.getMaxMana()) && Objects.equals(this.getResistances(), perso.getResistances()) && Objects.equals(this.getSpeed(), perso.getSpeed()) && this.getWeapon().equals(perso.getWeapon())) {
					return true ;
				} else {
					return false ;
				}
			}
	    	
	    }
	
	
}