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
        double burgerCost = facade.placeAndPriceOrder("burger", burgerToppings, burgerDiscount);
        totalIndividual += burgerCost;
        System.out.println(String.format("Burger Order Total: $%.2f | Discount: %s\n", burgerCost, burgerDiscount.getClass().getSimpleName()));


        // Order 2: Salad
        List<String> saladToppings = Arrays.asList("spices");
        DiscountStrategy saladDiscount = new TimeDiscount();
        Meal salad = facade.buildMeal("salad", saladToppings);
        double saladCost = saladDiscount.applyDiscount(salad.getCost());
        totalIndividual += saladCost;
        facade.placeOrder("salad", saladToppings, saladDiscount);
        System.out.printf("Salad Order Total: $%.2f | Discount: %s\n%n", saladCost, saladDiscount.getClass().getSimpleName());


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

            String discountType = request.discount.getClass().getSimpleName();
            System.out.printf("%s | Final Price: $%.2f | Discount: %s%n", meal.getDescription(), cost, discountType);
        }

        System.out.printf("Total for Grouped Orders: $%.2f%n", totalGrouped);


        // Apply SumDiscount to the total
        DiscountStrategy finalGroupDiscount = new SumDiscount();
        double finalGroupedCost = finalGroupDiscount.applyDiscount(totalGrouped);
        System.out.printf("Grouped Order with SumDiscount: $%.2f\n%n", finalGroupedCost);
    }
}
