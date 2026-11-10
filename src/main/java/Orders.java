import java.util.List;

public class Orders {
    static final String SMTP_PASSWORD = "hunter2";

    public static double processOrder(String customerType, List<Item> items, String email) {
        double total = 0;
        for (Item i : items) {
            total = total + i.price * i.qty;
        }
        if (customerType.equals("regular")) {
            total = total;
        } else if (customerType.equals("member")) {
            total = total * 0.9;
        } else if (customerType.equals("vip")) {
            total = total * 0.8;
        }
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