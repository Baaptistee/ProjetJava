package univers.personnages;

import univers.Eleme;
import univers.competences.CompetenceDammage;
import univers.competences.CompetenceSoin;
import univers.competences.CompetencesActives;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Map;
import Representation.Game;

/** 
 * une classe utilisée pour les personnages adverses dans les fight node
 * 
 */
public class PersonnageAdversaire extends PersonnageCombattant {
	
	private ArrayList<CompetencesActives> competences ; 
	private int[] probaCompetences ;
	private ArrayList<PersonnageCombattant> groupe ;
	
	/**
	 * le constructeur de la classe
	 * @param nom le nom du perso 
	 * @param description sa description
	 * @param dexterite la dexterite 
	 * @param force sa force 
	 * @param intelligence son intelligence 
	 * @param endurancen son endurance 
	 * @param speed sa vitesse 
	 * @param maxLifePoints son MAximum de points de vie 
	 * @param maxMana son maximum de mana 
	 * @param faiblesses ses faiblesses 
	 * @param resistances ses résistances 
	 * @param competences ses compétences 
	 * @param probaCompetences les probabilités de ses compétences 
	 */
	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed,  int maxLifePoints, int maxMana, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<CompetencesActives> competences, int[] probaCompetences) {
		super(nom, description, dexterite, force, intelligence, endurance, speed, maxMana, maxLifePoints, resistances, faiblesses) ;
		this.competences = competences ;
		this.probaCompetences = probaCompetences ;
		competenceBienInstanciees();
	}

	/**
	 * le constructeur de la classe
	 * @param nom le nom du perso 
	 * @param description sa description
	 * @param dexterite la dexterite 
	 * @param force sa force 
	 * @param intelligence son intelligence 
	 * @param endurancen son endurance 
	 * @param speed sa vitesse 
	 * @param maxLifePoints son MAximum de points de vie 
	 * @param maxMana son maximum de mana 
	 * @param faiblesses ses faiblesses 
	 * @param resistances ses résistances 
	 * @param competences ses compétences 
	 * @param probaCompetences les probabilités de ses compétences 
	 * @param image L'image path du perso 
	 */
	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed,  int maxLifePoints, int maxMana, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<CompetencesActives> competences, int[] probaCompetences, String image) {
		
		super(nom, description, image, dexterite, force, intelligence, endurance, speed, maxMana, maxLifePoints, resistances, faiblesses) ;
		this.competences = competences ;
		this.probaCompetences = probaCompetences ;
		competenceBienInstanciees();

	}

	/**
	 * un getter pour les compétences 
	 * @return les compétences 
	 */
	public ArrayList<CompetencesActives> getCompetences() {
		return competences;
	}
	/**
	 * un setter pour les compétences 
	 * @param competences les nouvelles compétences 
	 */
	public void setCompetences(ArrayList<CompetencesActives> competences) {
			this.competences = competences;
			competenceBienInstanciees();
	}
	
	/**
	 * un getter pour la proba des compétences
	 * @return les proba des compétences 
	 */
	public int[] getProbaCompetences() {
		return probaCompetences;
	}
	/**
	 * Un setter pour les proba compétence
	 * @param probaCompetences les nouvelles proba compétence 
	 */
	public void setProbaCompetences(int[] probaCompetences) {
			this.probaCompetences = probaCompetences;
			competenceBienInstanciees();
	}

	/** 
	 * un getter pour le groupe
	 * @return le groupe 
	 */
	public ArrayList<PersonnageCombattant> getGroupe() {
		return groupe;
	}

	/**
	 * Un getter pour le groupe vivant 
	 * @return le groupe Vivant 
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
	 * un setter pour le groupe 
	 * @param groupe le nouveau groupe 
	 */
	public void setGroupe(ArrayList<PersonnageCombattant> groupe) {
		this.groupe = groupe;
	}

	public void competenceBienInstanciees() throws IllegalStateException{
		if (this.competences.size()==0){
			throw new IllegalStateException("Le personnage n'a pas de compétences") ;
		} else if (this.probaCompetences.length!=this.competences.size()){
			throw new IllegalStateException("Il y a un problème avec les probabilités des attaques du personnage") ;
		} else {
			boolean b = false ;
			for (int i = 0; i<competences.size();i++){
				if((competences.get(i) instanceof CompetenceDammage)&&competences.get(i).getCoutMana()==0){
					b = true ;
				}
			}
			if (!b){
				throw new IllegalStateException("Le personnage n'a pas de compétence qu'il peut utiliser dans tous les cas !") ;
			}
		}
	}

	/**
	 * une fonction pour sélectionner de manière "aléatoire" une compétence
	 * @return l'attaque sélectionée
	 */
	public CompetencesActives selectionAttaque() {
			competenceBienInstanciees();
			Random random = new Random() ;
			int total = 0 ;
			CompetencesActives o = this.getCompetences().get(0) ;
			boolean manaCost = false ;
			boolean noUselessHeal = false ;
			while ((manaCost==false)||(noUselessHeal==false)){
				manaCost = false ;
				noUselessHeal = false ;
				for (int i = 0 ; i < this.getProbaCompetences().length ; i++){
					total += this.getProbaCompetences()[i] ;
				}

				int a = random.nextInt(total-1) + 1 ;
		
				total = 0 ;
				int i = 0 ;
				boolean pokemon = true ;

				while ((pokemon == true)&&(i < this.getProbaCompetences().length)){
					total += this.getProbaCompetences()[i] ;
					if (total >= a) {
						pokemon = false ;
						o = this.getCompetences().get(i) ;
					}
					i++ ;
				}
			// on vérifie que le personnage a assez de mana pour lancer la compétence 
				if (this.getMana()>=o.getCoutMana()) {
					manaCost = true ;
				}
				
				// on vérifie que si c'est une compétence de soin, il y a bien des personnages alliés à soigner 
				if (o instanceof univers.competences.CompetenceSoin) {
					for (int k = 0 ; k < this.getGroupe().size() ; k++){
						if (this.getGroupe().get(k).getLifePoints()<this.getGroupe().get(k).getMaxLifePoints()){
						noUselessHeal = true ;
						}
					}
				} else {
					noUselessHeal = true ;
				}
			}
			return o ;

	}

	/** 
	 * une fonction pour sélectionner la cible de cette attaque 
	 * @param competence la compétence utilisée 
	 * @return la cible 
	 */
	// une fonction pour la sélection aléatoire de la cible 
	public PersonnageCombattant selectionCible(CompetencesActives competence) {
		if (competence instanceof CompetenceSoin){
			boolean b = false ;
			for (int i = 0; i<this.getGroupe().size();i++){
				if(this.getGroupe().get(i).getLifePoints()<this.getGroupe().get(i).getMaxLifePoints()){
					b = true ;
				}
			}
			if (!b){
				throw new IllegalArgumentException("ERREUR de selection de compétence : compétence de soin alors qu'il n'y a pas d'allié blessé !!");
			}
		}

		PersonnageCombattant d = Game.getGame().getGroupeJoueurVivant().get(0) ;
		Random random = new Random() ;
		if (competence.isGroup()) {
			return null ;
		} else {
		// on ne se soucie pas des compétences ciblant des groupes ici, peu importe leur cible, elles affecteront le groupe ciblé 
		// si on lance une compétence de soin on le fait uniquement sur les allies 
		if (competence instanceof univers.competences.CompetenceSoin) {
			// on va vérifier que la cible est bien blessée 
			boolean z = true ;
			while (z){
				int i = random.nextInt(this.getGroupeVivant().size()) ;
				if (this.getGroupeVivant().get(i).getLifePoints()<this.getGroupeVivant().get(i).getMaxLifePoints()){
						z = false ;
						d = this.getGroupe().get(i) ;
				}
			}
		} else {
			
			int u = random.nextInt(Game.getGame().getGroupeJoueurVivant().size()) ;
			d = Game.getGame().getGroupeJoueurVivant().get(u) ;
			}
			return d ;
		}

	}
	
	/**
	 * Une fonction pour sélectionner à la fois l'attaque et la cible et l'ajouter dans une Map 
	 * @param actions la mapAction
	 * @return la map action
	 */
	public Map<PersonnageCombattant, Object[]> selectionTout(Map<PersonnageCombattant, Object[]> actions){
		// on ajoute l'action du personnage que si il est envie 
		if (this.enVie()) {

		Object[] c = new Object[2] ;
		c[0] = this.selectionAttaque() ;
		c[1] = this.selectionCible((CompetencesActives)c[0]) ;

		actions.put(this, c) ;
		}
		return  actions;
	}

	/**
	 * Pour convertir le personnage en String 
	 * @return La conversion en String 
	 */
	@Override
	public String toString() {
		return "PersonnageAdversaire " + super.toString() // A refaire il manque compétences mais je suis sur autre chose là
				+ Arrays.toString(probaCompetences) + ", groupe=" + groupe + "]";
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
			PersonnageAdversaire perso = (PersonnageAdversaire)obj ;
			if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getImageLien(), 
					perso.getImageLien()) && Objects.equals(this.getPersoId(), perso.getPersoId()) && Objects.equals(this.getDexterity() , perso.getDexterity()) && 
					Objects.equals(this.getStrength() , perso.getStrength()) && Objects.equals(this.getEndurance() , perso.getEndurance()) && Objects.equals(this.getFaiblesses() , 
					perso.getFaiblesses()) && Objects.equals( this.getGroupe() , perso.getGroupe()) && Objects.equals(this.getIntelligence() , perso.getIntelligence()) && 
					Objects.equals(this.getLevel() , perso.getLevel()) && Objects.equals(this.getLifePoints() , perso.getLifePoints()) && Objects.equals(this.getMana() , perso.getMana()) && 
					Objects.equals(this.getMaxLifePoints() , perso.getMaxLifePoints()) && Objects.equals(this.getMaxMana(), perso.getMaxMana()) && Objects.equals(this.getResistances(), perso.getResistances()) && 
					Objects.equals(this.getSpeed(), perso.getSpeed()) && Objects.equals(perso, obj) && Objects.equals(this.getProbaCompetences(), perso.getProbaCompetences()) && Objects.equals(this.getCompetences() , perso.getCompetences())) {
				return true ;
			} else {
				return false ;
			}
		}
    	
    }
	
}