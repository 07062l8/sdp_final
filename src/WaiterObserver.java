public class WaiterObserver implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Waiter received update: " + status);
    }
}
