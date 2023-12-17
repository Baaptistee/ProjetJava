package Event;
/**
 * An interface representing an event in a software system. Classes that implement this interface
 * are expected to provide methods for displaying information about the event.
 */
// Event.java
public interface Event {
    void display();
    Event chooseNext();
}
