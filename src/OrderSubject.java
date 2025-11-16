// Subject Class
import java.util.ArrayList;
import java.util.List;

public class OrderSubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

     // Notifies all registered observers with the given status.
    public void notifyObservers(String status) {
        for (Observer o : observers) {
            o.update(status);
        }
    }
}