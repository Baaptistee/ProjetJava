package Event;
import Interface.InterfaceJeu;

/**
 * A class that represents an image-related decorator for an event. It extends the AbstractDecorator class
 * and can be used to add image-related functionality to events.
 */
public class ImageNode extends AbstractDecorator {

    private String imageName;

    /**
     * Constructs an ImageNode with the provided decorated event and image name.
     * @param decoratedEvent The event to decorate.
     * @param imageName The name of the image associated with the event.
     */

    public ImageNode(Event decoratedEvent, String imageName) {
        super(decoratedEvent);
        if (imageName == null) {
            //throw new IllegalArgumentException("L'image du nom ne peut pas être null");
        }
        this.imageName = imageName;
    }

    /**
     * Gets the path of the associated image.
     * @return The path of the image.
     */

    public String getCheminImage() {
        return imageName;
    }

     /**
     * Displays the decorated event and adds image-related functionality.
     */

    @Override
    public void display() {
        super.display();
        ajoutFonctionnalite();
    }
    
    /**
     * Adds image-related functionality to the event.
     *
     */
    private void ajoutFonctionnalite() {
            InterfaceJeu.afficherImageDansInterface(imageName);
        // } else {
        //     throw new IllegalArgumentException("L'interface ne peut pas être null");
        // }
    }
    
     /**
     * Chooses the next event based on the decorated event.
     *
     * @return The next event.
     */

    @Override
    public Event chooseNext() {
        return super.chooseNext();
    }

    /**
     * Returns a string representation of the ImageNode.
     *
     * @return A string representation of the ImageNode.
     */

    @Override
    public String toString(){
        return "voici le path "+imageName;
    }

        
}