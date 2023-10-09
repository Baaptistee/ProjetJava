package univers.personnages;

import java.util.ArrayList;
import univers.armes.*;
import univers.competences.Competences;
import univers.personnages.*;

public class PersonnageAdversaire extends PersonnageCombattant {
	
	private ArrayList<Competences> competences ;
	
	public PersonnageAdversaire(String nom, String description, int dexterite, int force, int intelligence, int endurance, int maxLifePoints) {
		
		super(nom, description, dexterite, force, intelligence, endurance, maxLifePoints) ;
		
	}

}
