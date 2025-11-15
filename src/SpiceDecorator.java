// Spice Decorator
public class SpiceDecorator extends MealDecorator {
    public SpiceDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return baseMeal.getDescription() + " + Spices";
    }

    @Override
    public double getCost() {
        return baseMeal.getCost() + 0.5; // add spices cost
    }
}