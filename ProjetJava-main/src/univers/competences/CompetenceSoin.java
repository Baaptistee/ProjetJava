package univers.competences ;

import java.util.Random;

import univers.personnages.PersonnageCombattant;


public class CompetenceSoin extends CompetencesActives {
	private int powerHeal ; 
	private boolean groupHeal ;
	
	public CompetenceSoin(String nom, String description, int coutMana, int powerHeal, boolean groupHeal){
		super(nom, description, coutMana) ;
	}

	public int getPowerHeal() {
		return powerHeal;
	}

	public void setPowerHeal(int powerHeal) {
		this.powerHeal = powerHeal;
	}

	public boolean isGroupHeal() {
		return groupHeal;
	}

	public void setGroupHeal(boolean groupHeal) {
		this.groupHeal = groupHeal;
	}

	@Override
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		Random random = new Random() ;
		String d ;
		if (utilisateur.getMana()<this.getCoutMana()) {
			d = "Pas assez de mana, rien ne se passe" ;
		} else {
			d = utilisateur.getName() + " utilise " + this.getName() + ".";
			int a = this.getPowerHeal() + random.nextInt(getPowerHeal()/2) + utilisateur.getIntelligence() - 10 ;
			if (this.isGroupHeal()) {
				for (int i = 0 ; i<utilisateur.getGroupe().size() ; i++) {
					cible.getGroupe().get(i).heal(a) ;
					d += "/Tous les membres du groupe récupère " + a + " points de vie." ;
				}
			} else {
				utilisateur.heal(a) ;
				d += "/" + cible.getName() + " récupère " + a + " points de vie." ;
			}
		}
		return d ;
	}
	
}
