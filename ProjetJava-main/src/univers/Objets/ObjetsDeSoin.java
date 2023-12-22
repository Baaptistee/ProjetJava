package univers.Objets;

import Representation.Game;
import univers.Utilisable;
import univers.personnages.PersonnageCombattant;

/**
 * Une classe pour représenter els objets de soin 
 */
public class ObjetsDeSoin extends Objets implements Utilisable{

    private int pvRendu ;
    private int manaRendu ;

    /**
     * Le constructeur de la classe 
     * @param name le nom
     * @param pvRendu le nombre de pv rendu 
     * @param manaRendu le nombre de points de mana rendu 
     */
    public ObjetsDeSoin(String name, int pvRendu, int manaRendu) {
        super(name);
        this.pvRendu=pvRendu;
        this.manaRendu=manaRendu;
    }

    /**
     * Le constructeur de la classe 
     * @param name le nom
     * @param pvRendu le nombre de pv rendu 
     * @param manaRendu le nombre de points de mana rendu 
     */
    public ObjetsDeSoin(String name, String description, int pvRendu, int manaRendu) {
        super(name, description);
        this.pvRendu=pvRendu;
        this.manaRendu=manaRendu;
    }

    /**
     * Un getter pour les pv rendus 
     * @return les pv rendus 
     */
    public int getPVRendu(){
        return this.pvRendu;
    }

    /**
     * un getter pour le mana rendu
     * @return le mana rendu 
     */
    public int getManaRendu(){
        return this.manaRendu;
    }

    @Override
    /**
     * Une fonction pour utiliser l'objet 
     * @param perso cible de l'utilisation 
     * @return le String pour l'affichage dans l'interface 
     */
    public String utilisation(PersonnageCombattant perso) {
        String d = "";
        if (pvRendu!=0){
            d+=perso.getName()+" récupère "+this.pvRendu+" points de vie !<br>";
            perso.heal(pvRendu);
        }
        if (manaRendu!=0){
            d+=perso.getName()+" récupère "+this.manaRendu+" points de mana !<br>";
            perso.setMana(perso.getMana()+manaRendu);
        }

        Game.getGame().enleverInventaire(this);

        return d ;        //throw new UnsupportedOperationException("Unimplemented method 'uilisation'");
    }

    
}
