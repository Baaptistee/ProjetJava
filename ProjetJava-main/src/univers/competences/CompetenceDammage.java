package univers.competences;

import java.util.Random;

import univers.Eleme;
import univers.personnages.PersonnageCombattant;

public class CompetenceDammage extends CompetencesActives{
	private int accuracy ;
	private int power ;
	private boolean groupDammage ;
	private int nbHits ;
	private Eleme element ;
	private boolean physical ; // on fait la convention qu'une attaque non physique est donc magique
	
	public CompetenceDammage(String nom, String description, int coutMana, int accuracy, int power, int nbHits, Eleme element, boolean groupDammage, boolean physical){
		super(nom, description, coutMana) ;
		this.accuracy = accuracy ;
		this.power =power ;
		this.groupDammage = groupDammage ;
		this.nbHits = nbHits ;
		this.element = element ;
		this.physical = physical ;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isGroupDammage() {
		return groupDammage;
	}

	public void setGroupDammage(boolean groupDammage) {
		this.groupDammage = groupDammage;
	}

	public int getNbHits() {
		return nbHits;
	}

	public void setNbHits(int nbHits) {
		this.nbHits = nbHits;
	}

	public Eleme getElement() {
		return element;
	}

	public void setElement(Eleme element) {
		this.element = element;
	}

	public boolean isPhysical() {
		return physical;
	}

	public void setPhysical(boolean physical) {
		this.physical = physical;
	}

	@Override
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		Random random = new Random() ;
		String d ;
		int b ;
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = "Pas assez de mana, rien ne se passe" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + "./";
			if (this.isGroupDammage()) {
				for(int i = 0 ; i < cible.getGroupe().size() ; i++) {
					if (cible.getGroupe().get(i).esquive(this.getAccuracy(), utilisateur)) {
						d += getName() + " equive l'attaque et s'en tire sans dommage./" ;
					} else {
						if (this.isPhysical()) {
							b = this.getPower() + utilisateur.getStrength()/2 + random.nextInt(this.getPower()/2);
						} else {
							b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);

						}
						if (cible.getGroupe().get(i).getFaiblesses().contains(this.getElement())) {
							b *=2 ;
							d += "L'attaque est super efficace ! " ;
						}
						cible.getGroupe().get(i).dammage(b);
						d += cible.getGroupe().get(i).getName() + " subit " + b + " points de dégats." ;
					}
				}
			} else {
				if (cible.esquive(this.getAccuracy(), utilisateur)) {
					d += getName() + " equive l'attaque et s'en tire sans dommage./" ;
				} else {
					b = this.getPower() + utilisateur.getIntelligence()/2 + random.nextInt(this.getPower()/2);
					if (cible.getFaiblesses().contains(this.getElement())) {
						b *=2 ;
						d += "L'attaque est super efficace ! " ;
					}
					cible.dammage(b);
					d += cible.getName() + " subit " + b + " points de dégats." ;
				}
				
			}	
		}
		return d ;
	}
}
