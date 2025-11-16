import java.util.ArrayList;
import java.util.List;

// Singleton class that manages all restaurant orders.
public class OrderManager {

    // Static instance of the singleton
    private static OrderManager instance;

    // List to store all placed orders
    private List<Meal> orders;

    // Private constructor to prevent external instantiation
    private OrderManager() {
        orders = new ArrayList<>();
    }

    /**
     * Returns the single instance of OrderManager.
     * @return The singleton instance.
     */
    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    /**
     * Adds a meal to the order list.
     * @param meal The meal to add.
     */
    public void addOrder(Meal meal) {
        orders.add(meal);
        System.out.println("Order added: " + meal.getDescription());
    }

    /**
     * Returns the list of all orders.
     * @return List of meals.
     */
    public List<Meal> getOrders() {
        return orders;
    }

    /**
     * Clears all orders.
     */
    public void clearOrders() {
        orders.clear();
        System.out.println("All orders have been cleared.");
    }
}
