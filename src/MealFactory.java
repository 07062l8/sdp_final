// Factory Pattern Implementation
public class MealFactory {

    public Meal createMeal(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Meal type cannot be null");
        }

        switch (type.toLowerCase()) {
            case "salad":
                return new Salad();
            case "burger":
                return new Burger();
            case "pasta":
                return new Pasta();
            case "pizza":
                return new Pizza();
            case "steak":
                return new Steak();
            default:
                throw new IllegalArgumentException("Unknown meal type: " + type);
        }
    }
}