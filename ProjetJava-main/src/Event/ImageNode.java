package Event;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Representation.Node;
import Interface.InterfaceJeu;

/**
 * A class that represents an image-related decorator for an event. It extends the AbstractDecorator class
 * and can be used to add image-related functionality to events.
 */
public class ImageNode extends AbstractDecorator {

    private ImageIcon imageIcon;

    public ImageNode(Event decoratedEvent, ImageIcon imageIcon) {
        super(decoratedEvent);
        this.imageIcon=imageIcon;
    }

    public ImageIcon getCheminImage() {
        return imageIcon;
    }
    @Override
    public void display() {
        // Afficher une image
        super.display();
        ajoutFonctionnalite();
    }
    
    private void ajoutFonctionnalite() {
        InterfaceJeu interfaceJeu = Node.getInterface();
        if (interfaceJeu != null) {
            interfaceJeu.afficherImageDansInterface(imageIcon);
            //System.out.println("Fonctionnalité ajoutée par le décorateur");
    
    
        } else {
            System.out.println("Erreur : InterfaceJeu non disponible");
        }
    }

    @Override
    public Event chooseNext() {
        return super.chooseNext();
    }

    @Override
    public String toString(){
        return "voici le path "+imageIcon;
    }

        
}
