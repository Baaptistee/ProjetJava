package univers.competences;

import univers.personnages.PersonnageCombattant ;

public class SoinRapide extends CompetencesActives{
	private static SoinRapide instance ;
	
	private SoinRapide(String nom, String description) {
		super(nom, description) ;
	}
	
	public static SoinRapide getSoinRapide() {
		if (instance == null) {
			instance = new SoinRapide("Soin Rapide", "Rend un faible nombre de point de vie à un personnage") ;
		}
		return instance ;
	}
	
	// la méthode renvoie un String qui sera ensuite à afficher dans l'interfaceJeu avec la méthode associée 
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		String d = utilisateur.getName() + "utilise Soin Rapide sur " + cible.getName() +", " + cible.getName() + "récupère " ;
		int a = 8 + utilisateur.getIntelligence()/3 ;
		cible.heal(a);
		
		d += a + " points de vie." ;
		
		return d ;
	}
}

