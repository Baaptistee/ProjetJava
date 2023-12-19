package packageTest;
import org.junit.jupiter.api.Test;

import Representation.Game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach ;
import univers.Eleme ;
import univers.competences.CompetenceDammage;
import univers.competences.CompetenceSoin;
import univers.competences.CompetencesActives;
import univers.personnages.PersonnageAdversaire;
import univers.personnages.PersonnageCombattant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.HashMap;
import java.util.Map;

public class PersonnageAdversaireTest {

    private PersonnageAdversaire adversaire;      
    private CompetencesActives competence1;
    private CompetencesActives competence2;
    private ArrayList<CompetencesActives> competences ;

    @BeforeEach
    public void setUp(){
        this.competence1 = new CompetenceDammage("Competence1",  "",  0,  100, 20,  1, null, false, false);
        this.competence2 = new CompetenceDammage("Competence1",  "",  3,  100, 20,  1, null, false, false);
        this.competences = new ArrayList<>(Arrays.asList(competence1, competence2));
        int[] probaCompetences = {50, 50}; // 50% de chance pour chaque compétence
        this.adversaire = new PersonnageAdversaire("Adversaire", "Description", 10, 20, 15, 30, 5, 100, 50, new ArrayList<>(), new ArrayList<>(), competences, probaCompetences);
    }

    // Test de la méthode selectionAttaque
    @Test
    public void testSelectionAttaque() {
        // Sélection de l'attaque
        CompetencesActives attaque = adversaire.selectionAttaque();
        // Vérification que l'attaque sélectionnée est une des compétences du personnage
        assertTrue(competences.contains(attaque));
    }
    
    //Test de la méthode selectionAttaque quand mana = 0
    @Test 
    public void testSelectionAttaqueMana0() {
    	adversaire.setMana(0);
    	CompetencesActives attaque = adversaire.selectionAttaque();
    	assertEquals(attaque, competence1);
    }
    
    //Test de la méthode selectionAttaque quand pas de joueur blessé 
    @Test 
    public void testSelectionAttaquePasDeBlesse() {
    	int[] newProba = {10,90};
        CompetencesActives competenceSoin = new CompetenceSoin("Soin","",0,20, false);
        ArrayList<CompetencesActives> newCompetences = new ArrayList<>(Arrays.asList(competence1, competenceSoin));
        adversaire.setCompetences(newCompetences);
        PersonnageAdversaire adversaire2 = new PersonnageAdversaire("Adversaire2", "Description", 10, 20, 15, 30, 5, 100, 50, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new int[]{});
        ArrayList<PersonnageCombattant> groupe = new ArrayList<PersonnageCombattant>();
        groupe.add(adversaire);
        groupe.add(adversaire2);
        adversaire.setGroupe(groupe);
        adversaire2.setGroupe(groupe);
        adversaire.setProbaCompetences(newProba);
    	CompetencesActives attaque = adversaire.selectionAttaque();
    	
    	assertEquals(attaque, competence1);
    	
    }


    // test de la sélection de la cible blessée en cas de compétence de loin 
   @Test
    public void testSelectionCibleSoin() {
        PersonnageAdversaire adversaire2 = new PersonnageAdversaire("Adversaire2", "Description", 10, 20, 15, 30, 5, 100, 50, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new int[]{});
        adversaire2.setLifePoints(adversaire2.getLifePoints()-1);
        CompetencesActives competenceSoin = new CompetenceSoin("Soin","",0,20, false);
        ArrayList<PersonnageCombattant> groupe = new ArrayList<PersonnageCombattant>();
        groupe.add(adversaire);
        groupe.add(adversaire2);
        adversaire.setGroupe(groupe);
        adversaire2.setGroupe(groupe);
        competenceSoin.setGroup(false); // Définition de la compétence de soin comme ciblant un seul personnage 
        PersonnageCombattant cible = adversaire.selectionCible(competenceSoin);
        // Vérification que la cible sélectionnée est bien le personnage blessé
        assertTrue(cible.equals(adversaire2));
    }

    //Test de la sélection de cible ennemie 
    @Test
    public void testSelectionCible(){
        competence1.setGroup(false);
        PersonnageCombattant cible = adversaire.selectionCible(competence1);
        //Verification que la cible est dans le groupe joueur 
        assertTrue(Game.getGame().getGroupeJoueur().contains(cible));    
    }

    //test que quand la compétence est de groupe on retourne null
    @Test
    public void testSelectionCibleCompetenceGroup(){
        competence1.setGroup(true);
        PersonnageCombattant cible = adversaire.selectionCible(competence1);
        assertNull(cible);
    }


    // test quand personnage en vie 
    @Test
    public void testSelectionTout() {
        Map<PersonnageCombattant, Object[]> actions = new HashMap<PersonnageCombattant, Object[]>();
        PersonnageAdversaire adversaire2 = new PersonnageAdversaire("Adversaire2", "Description", 10, 20, 15, 30, 5, 100, 50, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new int[]{});
        Object[] remplissage = {null, null};
        actions.put(adversaire2, remplissage);
        adversaire.setAlive(true);
        int size = actions.size();
        Map<PersonnageCombattant, Object[]> newActions = adversaire.selectionTout(actions) ;

        assertTrue((size + 1)==newActions.size());
    }

    // test quand personnage Mort 
    @Test
    public void testSelectionToutQuandMort() {
        Map<PersonnageCombattant, Object[]> actions = new HashMap<PersonnageCombattant, Object[]>();
        adversaire.setAlive(false);
        int size = actions.size();
        Map<PersonnageCombattant, Object[]> newActions = adversaire.selectionTout(actions) ;
        assertTrue(size==newActions.size());
    }

}
