package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import univers.Eleme;
import univers.competences.CompetencesActives;
import univers.Statistiques;
import univers.personnages.PersonnageCombattant;

public class  PersonnageCombatantTest extends PersonnageCombattant {
	

	 public PersonnageCombatantTest() {
	        super("TestNom", "TestDescription", 10, 5, 8, 15, 20, 50, 100,
                new ArrayList<>(Arrays.asList(Eleme.FEU, Eleme.LUMIERE)),
                new ArrayList<>(Arrays.asList(Eleme.TENEBRE, Eleme.FOUDRE)));
	    }



	  @Override
    public ArrayList<PersonnageCombattant> getGroupe() {
       
        return new ArrayList<>();
    }

    @Override
    public void setGroupe(ArrayList<PersonnageCombattant> newGroup) {
       
    }

    @Override
    public ArrayList<PersonnageCombattant> getGroupeVivant() {
       
        return new ArrayList<>();
    }

    @Override
    public ArrayList<CompetencesActives> getCompetences() {
       
        return new ArrayList<>();
    }
	
	 

	@Test
	public void testToString() {
	String expectedToString = "[name=TestNom, description=TestDescription, img=null, persoId=1] [level=1, strength=5, intelligence=8, dexterity=10, speed=20, lifePoints=100, maxLifePoints=100, alive=true, endurance=15, mana=50, maxMana=50, faiblesses=[FEU, LUMIERE], resistances=[TENEBRE, FOUDRE]]";
    assertEquals(expectedToString.trim(), toString().trim());
	}

	@Test
	public void testEqualsObject() {
		 PersonnageCombattant perso1 = new PersonnageCombatantTest();
		 PersonnageCombattant perso2 = new PersonnageCombatantTest();
		 perso2.setStrength(15);
		 assertFalse(perso1.equals(perso2));
		 assertFalse(perso1.equals(new Object()));
	}

	@Test
	public void testTestStat() {
		assertTrue(testStat(10, Statistiques.DEXTERITY));
		assertTrue(testStat(15, Statistiques.ENDURANCE));
		assertTrue(testStat(20, Statistiques.SPEED));
		assertTrue(testStat(8, Statistiques.INTELLIGENCE));
		assertTrue(testStat(10, Statistiques.STRENGTH));
	}

	@Test
	public void testEnVieTrue() {
		assertTrue(enVie());
	}
	
	@Test
	public void testEnVieFalse() {
		setLifePoints(0);
		assertFalse(enVie());
	}

	@Test
public void testEsquiveNotGood() {
    int precision = 100;
    PersonnageCombatantTest lanceur = new PersonnageCombatantTest();
    lanceur.setSpeed(15); 
    lanceur.setDexterity(10); 
    assertFalse(esquive(precision, lanceur));
}
	@Test
public void testEsquiveGood() {
    int precision = 10;
    PersonnageCombatantTest lanceur = new PersonnageCombatantTest();
    lanceur.setSpeed(15); 
    lanceur.setDexterity(10); 
    assertTrue(esquive(precision, lanceur));
}


}