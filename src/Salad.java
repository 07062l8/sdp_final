// Concrete Meals
public class Salad extends Meal {
    @Override
    public String getDescription() {
        return "Salad🥗";
    }

    @Override
    public double getCost() {
        return 5.0; // base price for salad
    }
}