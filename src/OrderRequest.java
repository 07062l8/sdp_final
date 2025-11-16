import java.util.List;

public class OrderRequest {
    public String type;
    public List<String> toppings;
    public DiscountStrategy discount;

    public OrderRequest(String type, List<String> toppings, DiscountStrategy discount) {
        this.type = type;
        this.toppings = toppings;
        this.discount = discount;
    }
}
