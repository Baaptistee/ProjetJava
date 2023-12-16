package univers.personnages.test;

import java.util.ArrayList;

import univers.Eleme;
import univers.personnages.PersonnageCombattant;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import univers.Eleme;
import univers.Statistiques;
import univers.competences.CompetencesActives;
import java.util.ArrayList;


public class PersonnageCombatantTest {

     private PersonnageCombattant personnage;

    @Before
    public void setUp() {
        // Initialisation d'un personnage pour les tests
        ArrayList<Eleme> faiblesses = new ArrayList<>();
        ArrayList<Eleme> resistances = new ArrayList<>();
        personnage = new PersonnageCombattantImpl("Nom", "Description", 10, 20, 15, 30, 25, 50, 100, faiblesses, resistances);
    }

    @Test
    public void testInitialisation() {
        // Vérifiez si les valeurs initiales sont correctes
        assertEquals("Nom", personnage.getName());
        assertEquals("Description", personnage.getDescription());
        assertEquals(10, personnage.getDexterity());
        assertEquals(20, personnage.getStrength());
        assertEquals(15, personnage.getIntelligence());
        assertEquals(30, personnage.getEndurance());
        assertEquals(25, personnage.getSpeed());
        assertEquals(50, personnage.getMaxMana());
        assertEquals(100, personnage.getMaxLifePoints());
        assertTrue(personnage.getFaiblesses().isEmpty());
        assertTrue(personnage.getResistances().isEmpty());
        assertTrue(personnage.isAlive());
        assertEquals(0, personnage.getMana());
        assertEquals(100, personnage.getLifePoints());
        assertEquals(1, personnage.getLevel());
    }
    
}
