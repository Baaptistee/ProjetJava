package Event;

/**
 * A class that represents a sound-related decorator for an event. It extends the AbstractDecorator class
 * and can be used to add sound-related functionality to events.
 *
 */
public class SoundNode extends AbstractDecorator {
    
    /**
     * The SoundNode object representing the sound-related information associated with the event.
     */
    private SoundNode sound;

    /**
     * Constructs a SoundNode with the provided Event decorator and SoundNode object.
     *
     * @param decorator The Event object to decorate.
     * @param sound The SoundNode object representing sound-related information.
     */
    public SoundNode(Event decorator, SoundNode sound){
        super(decorator);
        this.sound = sound;
    }
}
