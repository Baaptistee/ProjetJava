package univers;

import univers.personnages.PersonnageCombattant;

public interface Utilisable extends Collectibles{
    
    /**
     * une fonction pour utiliser l'objet
     */
    String utilisation(PersonnageCombattant perso);
}
