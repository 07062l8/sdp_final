// Sauce Decorator
public class SauceDecorator extends MealDecorator {
    public SauceDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return baseMeal.getDescription() + " + Sauce";
    }

    @Override
    public double getCost() {
        return baseMeal.getCost() + 1.0; // add sauce cost
    }
}
