import java.util.*;

public class Main {
    public static void main(String[] args) {
        RestaurantFacade facade = new RestaurantFacade();

        //Scenario 1: Individual Orders
        System.out.println("=== Individual Orders ===");

        double totalIndividual = 0.0;

        // Order 1: Burger
        List<String> burgerToppings = Arrays.asList("cheese", "sauce");
        DiscountStrategy burgerDiscount = new StudentDiscount();
        Meal burger = facade.buildMeal("burger", burgerToppings);
        double burgerCost = burgerDiscount.applyDiscount(burger.getCost());
        totalIndividual += burgerCost;
        facade.placeOrder("burger", burgerToppings, burgerDiscount);
        System.out.println(String.format("Burger Order Total: $%.2f\n", burgerCost));

        // Order 2: Salad
        List<String> saladToppings = Arrays.asList("spices");
        DiscountStrategy saladDiscount = new TimeDiscount();
        Meal salad = facade.buildMeal("salad", saladToppings);
        double saladCost = saladDiscount.applyDiscount(salad.getCost());
        totalIndividual += saladCost;
        facade.placeOrder("salad", saladToppings, saladDiscount);
        System.out.println(String.format("Salad Order Total: $%.2f\n", saladCost));

        System.out.println(String.format("Total for Individual Orders: $%.2f\n", totalIndividual));

        // Scenario 2: One Big Order
        System.out.println("=== Grouped Multi-Item Order ===");

        List<OrderRequest> groupOrder = new ArrayList<>();
        groupOrder.add(new OrderRequest("pizza", Arrays.asList("cheese", "spices"), new StudentDiscount()));
        groupOrder.add(new OrderRequest("steak", Arrays.asList("sauce", "cheese"), new TimeDiscount()));
        groupOrder.add(new OrderRequest("pasta", Arrays.asList("sauce", "spices"), new StudentDiscount()));

        double totalGrouped = 0.0;

        for (OrderRequest request : groupOrder) {
            Meal meal = facade.buildMeal(request.type, request.toppings);
            double cost = request.discount.applyDiscount(meal.getCost());
            totalGrouped += cost;
            facade.placeOrder(request.type, request.toppings, request.discount);
            System.out.printf("%s | Final Price: $%.2f%n", meal.getDescription(), cost);
        }

        System.out.printf("\nSubtotal for Grouped Order: $%.2f%n", totalGrouped);

        // Apply SumDiscount to the total
        DiscountStrategy finalGroupDiscount = new SumDiscount();
        double finalGroupedCost = finalGroupDiscount.applyDiscount(totalGrouped);
        System.out.printf("Grouped Order with SumDiscount: $%.2f\n%n", finalGroupedCost);
    }
}
