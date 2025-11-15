// Abstract Decorator Class
public abstract class MealDecorator extends Meal {
    protected Meal baseMeal;

    // Constructor takes a base meal to decorate
    public MealDecorator(Meal meal) {
        this.baseMeal = meal;
    }
}
