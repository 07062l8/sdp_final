public class Pizza extends Meal {
    @Override
    public String getDescription() {
        return "Pizza";
    }

    @Override
    public double getCost() {
        return 10.0; // base price for pizza
    }
}
