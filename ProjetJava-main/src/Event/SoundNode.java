package Event;

import Interface.InterfaceJeu;
import Representation.Node;

/**
 * Une classe SoundNode qui étend la classe abstraite AbstractDecorator.
 * Cette classe sert de décorateur pour l'interface "Event", permettant d'ajouter ou de modifier
 * le comportement des implémentations concrètes de l'interface Event sans altérer leur code.
 * SoundNode contient une référence à un objet Event qu'il décore ainsi qu'une référence à un chemin de son.
 *
 * @param decoratedEvent L'objet Event à décorer.
 * @param soundName      Le nom du son associé à cet événement.
 * @throws IllegalArgumentException Si le nom du son est null lors de la création de l'objet SoundNode.
 */
public class SoundNode extends AbstractDecorator {

    String soundName;

    /**
     * Constructeur de la classe SoundNode.
     *
     * @param decoratedEvent L'objet Event à décorer.
     * @param soundName      Le nom du son associé à cet événement.
     * @throws IllegalArgumentException Si le nom du son est null lors de la création de l'objet SoundNode.
     */
    public SoundNode(Event decoratedEvent, String soundName) {
        super(decoratedEvent);
        if (soundName == null) {
            throw new IllegalArgumentException("Le nom du son ne peut pas être null");
        }
        this.soundName = soundName;
    }

    /**
     * Renvoie le chemin du son associé à cet événement.
     *
     * @return Le chemin du son.
     */
    public String getSoundPath() {
        return soundName;
    }

    /**
     * Affiche l'événement décoré et ajoute la fonctionnalité sonore associée.
     */
    @Override
    public void display() {
        super.display();
        ajoutFonctionnaliteSound();
    }

    /**
     * Ajoute la fonctionnalité sonore associée à l'événement dans l'interface du jeu.
     * Lance une exception si l'interface est null.
     *
     * @throws IllegalArgumentException Si l'interface est null.
     */
    private void ajoutFonctionnaliteSound() {
        InterfaceJeu interfaceJeu = Node.getInterface();
        if (interfaceJeu != null) {
            InterfaceJeu.afficherSoundDansInterface(soundName);
        } else {
            throw new IllegalArgumentException("L'interface ne peut pas être null");
        }
    }

    /**
     * Choisi l'événement suivant en utilisant la méthode de la classe parente.
     *
     * @return L'événement suivant.
     */
    @Override
    public Event chooseNext() {
        return super.chooseNext();
    }

    /**
     * Renvoie une représentation sous forme de chaîne de caractères de l'objet SoundNode.
     *
     * @return Une chaîne de caractères représentant l'objet SoundNode.
     */
    @Override
    public String toString() {
        return "voici le path " + soundName;
    }
}
