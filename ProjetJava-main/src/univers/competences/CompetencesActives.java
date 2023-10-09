package univers.competences;

import univers.personnages.PersonnageCombattant;

public abstract class CompetencesActives extends Competences {
	
	public CompetencesActives(String nom, String description){
		super(nom, description) ;
	}
	
	public abstract String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) ;
	
}
