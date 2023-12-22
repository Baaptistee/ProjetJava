package univers.competences;

import java.util.Objects;

import Representation.FightNode;
import univers.personnages.PersonnageCombattant;

/**
 * Une classe pour les compétences actives 
 */
public abstract class CompetencesActives extends Competences {
	
	private int coutMana ;
	/** 
	 * Le constructeur de la classe 
	 * @param nom le nom 
	 * @param description la description 
	 * @param coutMana le cout en mana 
	 */
	public CompetencesActives(String nom, String description, int coutMana){
		super(nom, description) ;
		try{
			if (coutMana < 0){
				throw new IllegalArgumentException("cout mana ne peut être négatif "+nom);
			}
			this.coutMana = coutMana ;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * un constructeur avec juste le nom 
	 * @param nom le nom 
	 */
	public CompetencesActives(String nom) {
		super(nom);
	}


	/**
	 * Un getter pour le cout en mana 
	 * @return le cout en mana 
	 */
	public int getCoutMana() {
		return coutMana;
	}

	public String affichageCoutMana(){
		if (this.coutMana==0){
			return "" ;
		} else{	
		return " <strong>"+this.coutMana+"PM</strong>";
		}
	}

	/**
	 * Un setter pour le cout en mana 
	 * @param coutMana le nouveau cout en mana 
	 */
	public void setCoutMana(int coutMana) {
		this.coutMana = coutMana;
	}

	/**
	 * Une méthode pour le transformer en String 
	 * @return le string de la compétence 
	 */
	@Override
	public String toString() {
		return super.toString() + "[coutMana=" + coutMana + "] " ;
	}
	
	/**
	 * Une méthode pour comparer à un autre objet 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetencesActives other = (CompetencesActives) obj;
		return this.getCoutMana() == other.getCoutMana() && 
			Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());

	}
	/**  
	 * La méthode qui va être utiliser pour utiliser la compétence 
	 * @param utilisateur le lanceur
	 * @param cible la cible
	 * @return renvoie un String qui sera ensuite à afficher dans le fightNode 
	 */
	public abstract String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible, FightNode node) ;
	/**
	 * Une méthode pour savoir si la compétence est de groupe 
	 * @return si la compétence est de groupe 
	 */
	public abstract boolean isGroup() ;
	/**
	 * Une méthode pour set la compétence est de groupe 
	 * @param b si la compétence est de groupe
	 */
	public abstract void setGroup(boolean b);
}