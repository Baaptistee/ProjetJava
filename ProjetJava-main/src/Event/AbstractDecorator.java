package Event;

import Representation.* ;



import Interface.InterfaceJeu;

/**
 * Une classe abstraite qui sert de base pour implémenter des décorateurs pour l'interface "Event". Les décorateurs sont utilisés pour ajouter ou modifier le comportement des implémentations concrètes de l'interface Event sans altérer leur code. Cette classe contient une référence à un objet Event qu'elle décore.
 */
abstract class AbstractDecorator implements Event {

    private Event decorator;

    /**
     * Constucteur 
     *
     * @param decorator L'objet a décorer 
     */
    public AbstractDecorator(Event decorator){
        this.decorator = decorator;
    }
    
    /**
     * Méthode pour afficher l'image dans le fond de l'interface
     */
    @Override
    public void display() {
        // Implémentation de base de l'affichage
        InterfaceJeu.afficherNodeBase((Node)decorator);
    }
    public Event getDecorator(){
        return decorator;
    }
    
    @Override
    public Event chooseNext() {
        return decorator.chooseNext();
    }
}




