public class Pasta extends Meal {
    @Override
    public String getDescription() {
        return "Pasta";
    }

    @Override
    public double getCost() {
        return 7.5; // base price for pasta
    }
}
