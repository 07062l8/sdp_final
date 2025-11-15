// Subject Class
import java.util.ArrayList;
import java.util.List;

public class OrderSubject {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Adds an observer to the list.
     * @param o The observer to add.
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes an observer from the list.
     * @param o The observer to remove.
     */
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifies all registered observers with the given status.
     * @param status The status message to send.
     */
    public void notifyObservers(String status) {
        for (Observer o : observers) {
            o.update(status);
        }
    }
}