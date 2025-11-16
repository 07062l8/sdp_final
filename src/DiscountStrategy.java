// Strategy Interface
public interface DiscountStrategy {
    /**
     * Applies a discount to the given amount.
     * @param amount The original price before discount.
     * @return The final price after applying discount.
     */
    double applyDiscount(double amount);
}
