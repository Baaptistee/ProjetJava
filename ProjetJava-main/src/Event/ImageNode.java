package Event;

/**
 * A class that represents an image-related decorator for an event. It extends the AbstractDecorator class
 * and can be used to add image-related functionality to events.
 */
public class ImageNode extends AbstractDecorator {

    /**
     * Constructs an ImageNode with the provided Event decorator.
     *
     * @param decorator The Event object to decorate.
     */
    public ImageNode(Event decorator){
        super(decorator);
    }

    // Additional methods and behavior specific to image-related decorators can be added here.
}
