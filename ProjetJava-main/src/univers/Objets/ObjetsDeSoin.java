package univers.Objets;

import Representation.Game;
import univers.Utilisable;
import univers.personnages.PersonnageCombattant;

public class ObjetsDeSoin extends Objets implements Utilisable{

    private int pvRendu ;
    private int manaRendu ;

    public ObjetsDeSoin(String name, int pvRendu, int manaRendu) {
        super(name);
        this.pvRendu=pvRendu;
        this.manaRendu=manaRendu;
    }
    
    
    // public String utilisation(PersonnageCombattant perso){
    //     String d = "";

    //     if (pvRendu!=0){
    //         d+=perso.getName()+" récupère "+this.pvRendu+" points de vie !<br>";
    //         perso.heal(pvRendu);
    //     }
    //     if (manaRendu!=0){
    //         d+=perso.getName()+" récupère "+this.manaRendu+" points de mana !<br>";
    //         perso.setMana(perso.getMana()+manaRendu);
    //     }

    //     Game.getGame().enleverInventaire(this);

    //     return d ;
    // }


    @Override
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
