public class Burger extends Meal {
    @Override
    public String getDescription() {
        return "Burger";
    }

    @Override
    public double getCost() {
        return 8.0; // base price for burger
    }
}
