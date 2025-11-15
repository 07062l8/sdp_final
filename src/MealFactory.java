// Factory Pattern Implementation
public class MealFactory {

    /**
     * Creates a Meal object based on the given type.
     * @param type The type of meal (salad, burger, pasta, pizza, steak).
     * @return A concrete Meal object.
     * @throws IllegalArgumentException if the type is unknown.
     */
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
