// Large Order Discount Strategy
public class SumDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        if (amount > 50) {
            return amount * 0.8; // 20% discount for orders over 50
        }
        return amount;
    }
}