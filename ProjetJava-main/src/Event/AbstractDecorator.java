package Event;



/**
 * An abstract class that serves as a base for implementing decorators for the "Event" interface.
 * Decorators are used to add or modify behavior of concrete Event implementations without altering their code.
 * This class contains a reference to an Event object that it decorates.
 */
abstract class AbstractDecorator implements Event {

    /**
     * The decorated Event object that this decorator wraps.
     */
    private Event decorator;
    
    /**
     * Constructs an AbstractDecorator with the provided Event object to decorate.
     *
     * @param decorator The Event object to be decorated.
     */
    public AbstractDecorator(Event decorator){
        if (decorator == null) {
            throw new IllegalArgumentException("Decorator cannot be null");
        }
        this.decorator = decorator;
    }

    /**
     * Displays the decorated event.
     */
   
    @Override
    public void display() {
        decorator.display();
    }

    /**
     * Gets the decorated Event object.
     * @return The decorated Event object.
     */
    
    public Event getDecorator(){
        return decorator;
    }

     /**
     * Chooses the next event based on the decorated event.
     * @return The next event.
     */
    
    @Override
    public Event chooseNext() {
        return decorator.chooseNext();
    }
}




