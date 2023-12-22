package Event;

import Interface.InterfaceJeu;
import Representation.Node;


// SoundNode.java
public class SoundNode extends AbstractDecorator {

    String soundName;

    public SoundNode(Event decoratedEvent, String soundName) {
        super(decoratedEvent);
        if(soundName==null){
            throw new IllegalArgumentException("Le nom du son ne peut pas être null");
        }
        this.soundName=soundName;
    }

    public String getSoundPath(){
        return soundName;
    }


    @Override
    public void display() {
        super.display();
        ajoutFonctionnaliteSound();
        
    }

    private void ajoutFonctionnaliteSound() {
        InterfaceJeu interfaceJeu = Node.getInterface();
        if (interfaceJeu != null) {
            InterfaceJeu.afficherSoundDansInterface(soundName);
        } else {
            throw new IllegalArgumentException("L'interface ne peut pas être null");
        }
    }

    @Override
    public Event chooseNext() {
        return super.chooseNext();
    }

    @Override
    public String toString(){
        return "voici le path "+soundName;
    }
}