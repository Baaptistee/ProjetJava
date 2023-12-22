package Event;

/**
 * Une interface pour des event destinés à affecter l'interface (son et image)
 */
 public interface Event {
    void display();
    Event chooseNext();
}
