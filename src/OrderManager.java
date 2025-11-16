import java.util.ArrayList;
import java.util.List;

// Singleton class that manages all restaurant orders.
public class OrderManager {

    // Static instance of the singleton
    private static OrderManager instance;

    private List<Meal> orders;

    // Private constructor to prevent external instantiation
    private OrderManager() {
        orders = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void addOrder(Meal meal) {
        orders.add(meal);
        System.out.println("Order added: " + meal.getDescription());
    }

    public List<Meal> getOrders() {
        return orders;
    }

    public void clearOrders() {
        orders.clear();
        System.out.println("All orders have been cleared.");
    }
}
