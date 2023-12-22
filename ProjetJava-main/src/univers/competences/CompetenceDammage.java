package univers.competences;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import Representation.FightNode;
import Representation.Game;
import univers.Eleme;
import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageCombattant;

/**
 * La classe pour les compétences infligeant des dégats 
 */
public class CompetenceDammage extends CompetencesActives{
	
	
	private int accuracy ;
	private int power ;
	private boolean groupDammage ;
	private int nbHits ;
	private Eleme element ;
	private boolean physical ; // on fait la convention qu'une attaque non physique est donc magique
	
	/** Le constructeur de la classe 
	 * 
	 * @param nom Le nom de la compétence 
	 * @param description la description de la compétence 
	 * @param coutMana le coût Mana 
	 * @param accuracy la précision 
	 * @param power la puissance de la capacacité 
	 * @param nbHits Les nombres de coups 
	 * @param element l'element de l'attaque 
	 * @param groupDammage si les dommages sont de groupe ou pas 
	 * @param physical si la capacité est physique ou pas 
	 */
	public CompetenceDammage(String nom, String description, int coutMana, int accuracy, int power, int nbHits, Eleme element, boolean groupDammage, boolean physical){
		super(nom, description, coutMana) ;
		this.accuracy = accuracy ;
		this.power =power ;
		this.groupDammage = groupDammage ;
		this.nbHits = nbHits ;
		this.element = element ;
		this.physical = physical ;
	}

	
	/**
	 * Le getter pour la précision 
	 * @return la précision
	 */
	public int getAccuracy() {
		return accuracy;
	}
	/**
	 * le setter pour la précision
	 * @param accuracy la nouvelle précision 
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	/**
	 * Un getter pour la puissance  
	 * @return la puissance de l'attaque 
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * Le setter de la puissance 
	 * @param power la nouvelle puissance 
	 */
	public void setPower(int power) {
		this.power = power;
	}
	
	/**
	 * Un getter pour le dommage de groupe 
	 * @return si la capacité est de groupe ou pas 
	 */
	public boolean isGroup() {
		return groupDammage;
	}
	
	/**
	 * Un setter pour si la capacité est de groupe ou pas 
	 * @param groupDammage si la capacité est de groupe 
	 */
	public void setGroup(boolean groupDammage) {
		this.groupDammage = groupDammage;
	}
	
	/**
	 * Un getter pour le nombre de coups 
	 * @return le nombre de coup 
	 */
	public int getNbHits() {
		return nbHits;
	}
	
	/**
	 * Un setter pour le nombre de hit 
	 * @param nbHits le nouveau nombre de hit 
	 */
	public void setNbHits(int nbHits) {
		this.nbHits = nbHits;
	}
	
	/**
	 * le getter l'élément de la capacité 
	 * @return l'élément de la capacité 
	 */
	public Eleme getElement() {
		return element;
	}
	
	/**
	 * Un setter pour l'élément de la capacité 
	 * @param element le nouvel élément 
	 */
	public void setElement(Eleme element) {
		this.element = element;
	}
	
	/**
	 * Un getter pour si la compétence est physique ou magique 
	 * @return si la fonction est physique ou magique
	 */
	public boolean isPhysical() {
		return physical;
	}
	
	/**
	 * Un setter pour si la compétence est physique ou magique 
	 * @param physical le nouveau si la compétence est magique ou pas 
	 */
	public void setPhysical(boolean physical) {
		this.physical = physical;
	}
	
	/**
	 * La fonction pour transformer en String 
	 */
	@Override
	public String toString() {
		return "CompetenceDammage " + super.toString() + " [accuracy=" + accuracy + ", power=" + power + ", groupDammage=" + groupDammage
				+ ", nbHits=" + nbHits + ", element=" + element + ", physical=" + physical + "]";
	}
	
	/**
	 * La fonction pour comparer et vois si c'est égal à un autre objet 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenceDammage other = (CompetenceDammage) obj;
		return this.getAccuracy() == other.getAccuracy() && getElement() == other.getElement() && this.isGroup() == other.isGroup()
				&& this.getNbHits() == other.getNbHits() && this.isPhysical() == other.isPhysical() && this.getPower() == other.getPower() &&
				this.getCoutMana() == other.getCoutMana() && 
				Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());
	}
	
	
	/**
	 * Une fonction pour utiliser la compétence
	 * @param utilisateur l'utilisateur de la compétence 
	 * @param cible la cible de la compétence
	 * @param node le node actuel 
	 */
	@Override
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible, FightNode node) {
		Random random = new Random() ;
		String d ;
		int b ;
		if (this.isGroup()){
			if(utilisateur instanceof PersoGroupe){
				cible = node.getOpponents().get(0);
			} else {
				cible = Game.getGame().getGroupeJoueur().get(0);
			}
		}
		// on teste si l'utilisateur a assez de mana 
		if (cible.getGroupeVivant().size()==0){
			d = "nope" ;
			return d ;
		} else if(!cible.enVie()){
			cible = cible.getGroupeVivant().get(0) ;
		}
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = utilisateur.getName()+" essaie d'utiliser "+ this.getName()+"/Pas assez de mana, rien ne se passe !/" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + "./";
			utilisateur.setMana(utilisateur.getMana()-this.getCoutMana());
			// on effectue l'action le nb de cout qu'est censée taper l'attaque 
			for (int x=0 ; x<this.getNbHits() ; x++) {
				// on parcoure le groupe en cas de dommages de groupe
				if (this.isGroup()) {
					ArrayList<PersonnageCombattant> groupeCible = cible.getGroupeVivant();
					for(PersonnageCombattant persoCible : groupeCible) {
						//on appelle la méthode esquive qui permet de savoir si le personnage a esquivé l'attaque 
						if (persoCible.esquive(this.getAccuracy(), utilisateur)) {
							d += persoCible.getName() + " equive l'attaque et s'en tire sans dommage./" ;
						} else {
							// en cas de dommages physiques on se base sur la force et en cas de dégats magiques sur l'intelligence 
							if (this.isPhysical()) {
								b = this.getPower() + utilisateur.getStrength()/2 + random.nextInt(this.getPower()/2);
							} else {
								b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);
							}
							// en cas de faiblesse élémentaire la cible subit 2 fois plus de dégâts 
							if (persoCible.getFaiblesses().contains(this.getElement())) {
								b *=2 ;
								d += "L'attaque est super efficace ! /" ;
							} else if (persoCible.getResistances().contains(this.getElement())) {
								b /=2 ;
								d += "L'attaque n'est pas très efficace ... /" ;
							}
							persoCible.dammage(b);
							d += persoCible.getName() + " subit " + b + " points de dégats./" ;
							if (!persoCible.enVie()){
								cible.setAlive(false);
								
								d += cible.getName() + " est vaincu(e) !/" ;
								System.out.println(d) ;
							}
						}
					}
				} else {
					if (cible.esquive(this.getAccuracy(), utilisateur)) {
						d += cible.getName() + " equive l'attaque et s'en tire sans dommage./" ;
					} else {
						b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);
						if (cible.getFaiblesses().contains(this.getElement())) {
							b *=2 ;
							d += "L'attaque est super efficace ! " ;
						} else if (cible.getResistances().contains(this.getElement())) {
								b /=2 ;
								d += "L'attaque n'est pas très efficace ... /" ;
						}
						cible.dammage(b);
						d += cible.getName() + " subit " + b + " points de dégats. /" ;
						if (!cible.enVie()){
							cible.setAlive(false);
							d += cible.getName() + " est vaincu(e) !/" ;
						}
					}
				
				}	
			}
		}
		return d ;
	}
}