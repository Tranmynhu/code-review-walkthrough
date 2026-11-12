import java.util.List;
import java.util.Map;

public class Orders {
    static final String SMTP_PASSWORD = "hunter2";

    static double STAFF_DISCOUNT_RATE = 0.3;
    private static final Map<String, Double> DISCOUNT_RATES = Map.of(
      "regular", 0.0,
      "member", 0.1,
      "vip", 0.2,
      "staff", STAFF_DISCOUNT_RATE
    );

    public static double processOrder(String customerType, List<Item> items, String email) {
        double total = 0;
        for (Item i : items) {
            total = total + i.price * i.qty;
        }

        // apply discount
        double discount = DISCOUNT_RATES.getOrDefault(customerType, 0.0);
        total = total * (1-discount);

        // apply tax
        double tax = total * 0.0825;
        total = total + tax;

        try {
            EmailClient s = new EmailClient("localhost", 2525, "shop@example.com", SMTP_PASSWORD);
            s.send(email, "Your total is " + total);
        } catch (Exception e) {
        }
        System.out.println("Receipt: " + total);
        return total;
    }
}