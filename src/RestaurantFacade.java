import java.util.List;

// Facade class that simplifies the process of placing a restaurant order.
// It integrates Factory, Decorator, Strategy, Observer, and Singleton patterns.

public class RestaurantFacade {

    private MealFactory factory;
    private OrderSubject subject;
    private OrderManager manager;

     // Constructor initializes factory, subject, and singleton manager.
     // Also registers default observers.

    public RestaurantFacade() {
        factory = new MealFactory();
        subject = new OrderSubject();
        manager = OrderManager.getInstance();

        // Register default observers
        subject.addObserver(new KitchenObserver());
        subject.addObserver(new CustomerObserver());
        subject.addObserver(new WaiterObserver());
    }

     // Places an order with specified meal type, toppings, and discount strategy.
    public void placeOrder(String type, List<String> toppings, DiscountStrategy discount) {
        try {
            // Create base meal using factory
            Meal meal = factory.createMeal(type);

            // Apply decorators based on toppings
            for (String topping : toppings) {
                switch (topping.toLowerCase()) {
                    case "cheese":
                        meal = new CheeseDecorator(meal);
                        break;
                    case "sauce":
                        meal = new SauceDecorator(meal);
                        break;
                    case "spices":
                        meal = new SpiceDecorator(meal);
                        break;
                    default:
                        System.out.println("Unknown topping: " + topping);
                }
            }

            // Apply discount strategy
            double finalCost = discount.applyDiscount(meal.getCost());

            // Save order using singleton
            manager.addOrder(meal);

            // Notify observers
            String status = String.format("Order placed: %s", meal.getDescription());
            subject.notifyObservers(status);

        } catch (IllegalArgumentException e) {
            System.out.println("Error placing order: " + e.getMessage());
        }
    }

    public void placeMultipleOrders(List<OrderRequest> requests) {
        for (OrderRequest request : requests) {
            placeOrder(request.type, request.toppings, request.discount);
        }
    }

    public Meal buildMeal(String type, List<String> toppings) {
        Meal meal = factory.createMeal(type);
        for (String topping : toppings) {
            switch (topping.toLowerCase()) {
                case "cheese": meal = new CheeseDecorator(meal); break;
                case "sauce": meal = new SauceDecorator(meal); break;
                case "spices": meal = new SpiceDecorator(meal); break;
            }
        }
        return meal;
    }

}
