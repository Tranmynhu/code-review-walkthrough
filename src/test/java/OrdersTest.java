import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void regularCustomerPaysNoDiscount() {
        List<Item> items = List.of(new Item(10.0, 2));
        assertEquals(21.65, Orders.processOrder("regular", items, "a@b.com"), 0.001);
    }

    @Test
    void memberGetsTenPercentOff() {
        List<Item> items = List.of(new Item(10.0, 2));
        assertEquals(19.485, Orders.processOrder("member", items, "a@b.com"), 0.001);
    }
}