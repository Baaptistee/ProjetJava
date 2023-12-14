package Event;

import java.util.ArrayList;

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
    private ArrayList<AbstractDecorator> options ;

    /**
     * Constructs an AbstractDecorator with the provided Event object to decorate.
     *
     * @param decorator The Event object to be decorated.
     */
    public AbstractDecorator(Event decorator){
        this.decorator = decorator;
    }
   
    @Override
    public void display() {
        // Implémentation de base de l'affichage
       
           decorator.display();
        System.out.println("Displaying Abstract Node");
    }
    public Event getDecorator(){
        return decorator;
    }
    
    @Override
    public Event chooseNext() {
        return decorator.chooseNext();
    }
}




