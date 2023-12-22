package univers.competences ;

import java.util.Objects;
import java.util.Random;

import Representation.FightNode;
import Representation.Game;
import univers.personnages.PersoGroupe;
import univers.personnages.PersonnageCombattant;

/**
 * La classe pour les compétences de soin 
 */
public class CompetenceSoin extends CompetencesActives {
	
	
	private int powerHeal ; 
	private boolean groupHeal ;

	/**
	 * Le constructeur de la classe 
	 * @param nom le nom de la classe 
	 * @param description la description de la classe 
	 * @param coutMana le cout en Mana 
	 * @param powerHeal la puissance de soin 
	 * @param groupHeal si la compétence soigne de le groupe ou pas 
	 */
	public CompetenceSoin(String nom, String description, int coutMana, int powerHeal, boolean groupHeal){
		super(nom, description, coutMana) ;
		try{ if (powerHeal<=0){
			throw new IllegalArgumentException("Power heal égal à zéro attention !");
		}
		this.powerHeal = powerHeal ;
		
		this.groupHeal = groupHeal ;
	} catch (IllegalArgumentException e){
		System.out.println(e.getMessage()) ;
	}
	}
	
	/**
	 * Un getter pour la puissance de soin 
	 * @return la puissance de soin 
	 */
	public int getPowerHeal() {
		return powerHeal;
	}
	
	/**
	 * un setter pour la puissance de soin 
	 * @param powerHeal la nouvelle puissance de soin 
	 */
	public void setPowerHeal(int powerHeal) {
		try {
			if (powerHeal<0){
				throw new IllegalArgumentException("impossible pour powerHeal d'être à zéro");
			}
			this.powerHeal = powerHeal;
		} catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Un getter pour si la compétence soigne le groupe
	 * @return si la compétence soigne le groupe 
	 */
	public boolean isGroup() {
		return groupHeal;
	}
	
	/**
	 * Un setter pour si la compétence soigne le groupe 
	 * @param si la compétence soigne le groupe 
	 */
	public void setGroup(boolean groupHeal) {
		this.groupHeal = groupHeal;
	}
	
	/**
	 * une méthode pour transformer en String 
	 * @return la compétence en String 
	 */
	@Override
	public String toString() {
		return "CompetenceSoin " + super.toString() + "[powerHeal=" + powerHeal + ", groupHeal=" + groupHeal + "]";
	}
	
	/**
	 * 
	 * @param obj l'objet à comparer 
	 * @return si les objets sont égaux 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompetenceSoin other = (CompetenceSoin) obj;
		return this.isGroup() == other.isGroup() && this.getPowerHeal() == other.getPowerHeal() && this.getCoutMana() == other.getCoutMana() && 
				Objects.equals(this.getDescription(), other.getDescription()) && Objects.equals(this.getName(), other.getName());
	}
	
	@Override
	/** the fonction utilisation is the one used to call the competence 
	 * @param the user of the competence 
	 * @param the target of the competence 
	 */
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible, FightNode node) {
		try {

		if (this.isGroup()){
			if(utilisateur instanceof PersoGroupe){
				cible = Game.getGame().getGroupeJoueur().get(0);
			} else {
				cible = node.getOpponents().get(0);
			}
		}

		if (utilisateur==null){
			throw new IllegalArgumentException("utilisateur null !!");
		}
		Random random = new Random() ;
		String d ;
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = utilisateur.getName()+" essaie d'utiliser "+ this.getName()+"Pas assez de mana, rien ne se passe !/" ;
		} else {
			utilisateur.setMana(utilisateur.getMana()-this.getCoutMana());
			d = utilisateur.getName() + " utilise " + this.getName() + ".";
			int a = this.getPowerHeal() + random.nextInt(getPowerHeal()/2) + utilisateur.getIntelligence() - 10 ;
			if (this.isGroup()) {
				for (int i = 0 ; i<utilisateur.getGroupe().size() ; i++) {
					utilisateur.getGroupe().get(i).heal(a) ;
					d += "/Tous les membres du groupe récupère " + a + " points de vie./" ;
				}
			} else {
				cible.heal(a) ;
				d += "/" + cible.getName() + " récupère " + a + " points de vie./" ;
			}
		}
		return d ;
	} catch (IllegalArgumentException e){
		System.out.println(e.getMessage()) ;
		return "";
	}
	}
	
}