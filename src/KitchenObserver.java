// Concrete Observers
public class KitchenObserver implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Kitchen received update: " + status);
    }
}