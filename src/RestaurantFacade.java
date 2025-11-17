import java.util.List;
public class RestaurantFacade {

    private MealFactory factory;
    private OrderSubject subject;
    private OrderManager manager;

    public RestaurantFacade() {
        factory = new MealFactory();
        subject = new OrderSubject();
        manager = OrderManager.getInstance();

        // Register default observers
        subject.addObserver(new KitchenObserver());
        subject.addObserver(new CustomerObserver());
        subject.addObserver(new WaiterObserver());
    }

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
            String status = String.format("Order placed: %s | Final cost: $%.2f", meal.getDescription(), finalCost);
            subject.notifyObservers(status);

        } catch (IllegalArgumentException e) {
            System.out.println("Error placing order: " + e.getMessage());
        }
    }

    public double placeMultipleOrders(List<OrderRequest> requests) {
        double total = 0.0;

        for (OrderRequest request : requests) {
            Meal meal = buildMeal(request.type, request.toppings);
            double cost = request.discount.applyDiscount(meal.getCost());
            total += cost;

            OrderManager.getInstance().addOrder(meal);
            subject.notifyObservers("New order: " + meal.getDescription());

            String discountType = request.discount.getClass().getSimpleName();
            System.out.printf("%s | Final Price: $%.2f | Discount: %s%n", meal.getDescription(), cost, discountType);
        }

        return total;
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

    public double placeAndPriceOrder(String type, List<String> toppings, DiscountStrategy discount) {
        Meal meal = buildMeal(type, toppings);
        double finalCost = discount.applyDiscount(meal.getCost());
        OrderManager.getInstance().addOrder(meal);
        subject.notifyObservers("New order: " + meal.getDescription());
        return finalCost;
    }

}