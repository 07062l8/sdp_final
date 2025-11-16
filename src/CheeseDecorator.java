// Cheese Decorator
public class CheeseDecorator extends MealDecorator {
    public CheeseDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return baseMeal.getDescription() + " + Cheese🧀";
    }

    @Override
    public double getCost() {
        return baseMeal.getCost() + 1.5; // add cheese cost
    }
}
