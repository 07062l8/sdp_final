public class Steak extends Meal {
    @Override
    public String getDescription() {
        return "Steak";
    }

    @Override
    public double getCost() {
        return 15.0; // base price for steak
    }
}
