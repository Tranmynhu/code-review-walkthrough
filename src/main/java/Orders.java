import java.util.List;
import java.util.Map;

public class Orders {
    static final String SMTP_PASSWORD = "hunter2";

    private static final Map<String, Double> DISCOUNT_RATES = Map.of(
      "regular", 0.0,
      "member", 0.1,
      "vip", 0.2,
      "staff", 0.3
    );

    public static double processOrder(String customerType, List<Item> items, String email) {
        double total = 0;
        for (Item i : items) {
            total = total + i.price * i.qty;
        }

        double discount = DISCOUNT_RATES.getOrDefault(customerType, 0.0);
        total = total * (1-discount);

        total = total + total * 0.0825;
        try {
            EmailClient s = new EmailClient("localhost", 2525, "shop@example.com", SMTP_PASSWORD);
            s.send(email, "Your total is " + total);
        } catch (Exception e) {
        }
        System.out.println("Receipt: " + total);
        return total;
    }
}