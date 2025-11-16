// Time-Based Discount Strategy
public class TimeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.85; // 15% discount during lunch hours
    }
}