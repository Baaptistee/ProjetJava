package univers.competences;
import univers.personnages.PersonnageCombattant ;

public class CoupSoigneur extends CompetencesActives {
	private static CoupSoigneur instance ;
	
	private CoupSoigneur(String nom, String description) {
		super(nom, description) ;
	}
	
	public static CoupSoigneur getCoupSoigneur() {
		if (instance == null) {
			instance = new CoupSoigneur("Frappe de soin", "Lance une attaque physique sur un adversaire, rend une partie des dégâts infligés à tous les membres de l'équipe") ;
		}
		return instance ;
	}
	
	// la méthode renvoie un String qui sera ensuite à afficher dans l'interfaceJeu avec la méthode associée 
	public String utilisation(PersonnageCombattant utilisateur, PersonnageCombattant cible) {
		String d = utilisateur.getName() + "utilise Frappe de Soin sur " + cible.getName() + ", " + cible.getName() + "subit " ;
		int a = 10 + utilisateur.getStrength()/2 ;
		cible.dammage(a) ;
				
		d += a + " points de dégâts." ;
		
		// à terme un truc pour get tous les membres du groupe mais pour l'instant on a pas haha 
		a = a/3 ;
		//groupeheal(a)
		d += " Le groupe récupère " + a + " Points de vie." ; 
		
		return d ;
	}
}
