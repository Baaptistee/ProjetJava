package univers.personnages;

import univers.Eleme;
//import java.util.ArrayList;
//import univers.armes.*;
//import univers.competences.Competences;
import univers.competences.CompetencesActives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
//import java.util.HashMap;
import java.util.Map;
//import univers.personnages.*;

import Representation.Game;

/** 
 * une classe utilisée pour les personnages adverses dans les fight node
 * 
 */
public class PersonnageAdversaire extends PersonnageCombattant {
	/**
	 * les competences du personnages
	 */
	private ArrayList<CompetencesActives> competences ; // un tableau avec les compétences utilisables par le personnage ainsi que la probabilité que celui-ci l'utilise 
	/** 
	 * la proba associée à chacune de ces compétences 
	 */
	private int[] probaCompetences ;
	/**
	 * le groupe de ce personnage combattant
	 */
	private ArrayList<PersonnageCombattant> groupe ;
	
	/**
	 * le constructeur de la classe
	 * @param nom
	 * @param description
	 * @param dexterite
	 * @param force
	 * @param intelligence
	 * @param endurance
	 * @param speed
	 * @param maxLifePoints
	 * @param maxMana
	 * @param faiblesses
	 * @param resistances
	 * @param competences
	 * @param probaCompetences
	 */
	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed,  int maxLifePoints, int maxMana, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<CompetencesActives> competences, int[] probaCompetences) {
		
		super(nom, description, dexterite, force, intelligence, endurance, speed, maxMana, maxLifePoints, resistances, faiblesses) ;
		this.competences = competences ;
		this.probaCompetences = probaCompetences ;
	}

	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int speed,  int maxLifePoints, int maxMana, ArrayList<Eleme> faiblesses, ArrayList<Eleme> resistances, ArrayList<CompetencesActives> competences, int[] probaCompetences, String image) {
		
		super(nom, description, dexterite, force, intelligence, endurance, speed, maxMana, maxLifePoints, resistances, faiblesses) ;
		this.competences = competences ;
		this.probaCompetences = probaCompetences ;
	}
	/**
	 * un getter pour les compétences 
	 * @return
	 */
	public ArrayList<CompetencesActives> getCompetences() {
		return competences;
	}
	/**
	 * un setter pour les compétences 
	 * @param competences
	 */
	public void setCompetences(ArrayList<CompetencesActives> competences) {
		this.competences = competences;
	}
	
	/**
	 * un getter pour la proba des compétences
	 * @return
	 */
	public int[] getProbaCompetences() {
		return probaCompetences;
	}
	/** 
	 * un getter pour le groupe
	 */
	public ArrayList<PersonnageCombattant> getGroupe() {
		return groupe;
	}

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
	 * @param groupe
	 */
	public void setGroupe(ArrayList<PersonnageCombattant> groupe) {
		this.groupe = groupe;
	}

	/**
	 * une fonction pour sélectionner de manière "aléatoire" une compétence
	 * @return
	 */
	public CompetencesActives selectionAttaque() {
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
	 * @param competence
	 * @return
	 */
	// une fonction pour la sélection aléatoire de la cible 
	public PersonnageCombattant selectionCible(CompetencesActives competence) {
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
	
	public Map<PersonnageCombattant, Object[]> selectionTout(Map<PersonnageCombattant, Object[]> actions){
		// on ajoute l'action du personnage que si il est envie 
		if (this.enVie()) {

		Object[] c = {} ;
		c[0] = this.selectionAttaque() ;
		c[1] = this.selectionCible((CompetencesActives)c[0]) ;

		actions.put(this, c) ;
		}
		return  actions;
	}

	@Override
	public String toString() {
		return "PersonnageAdversaire " + super.toString() // A refaire il manque compétences mais je suis sur autre chose là
				+ Arrays.toString(probaCompetences) + ", groupe=" + groupe + "]";
	}
	@Override
    public boolean equals(Object obj) {
		if (this == obj) {
			return true ;
		} else if (obj.getClass() != this.getClass()) {
			return false ;
		} else {
			PersonnageAdversaire perso = (PersonnageAdversaire)obj ;
			if (Objects.equals(this.getName(), perso.getName()) && Objects.equals(this.getDescription(), perso.getDescription()) && Objects.equals(this.getImage(), 
					perso.getImage()) && Objects.equals(this.getPersoId(), perso.getPersoId()) && Objects.equals(this.getDexterity() , perso.getDexterity()) && 
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