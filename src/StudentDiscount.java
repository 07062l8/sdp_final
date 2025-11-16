// Student Discount Strategy
public class StudentDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9; // 10% discount for students
    }
}