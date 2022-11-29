import UseCases.Notification.SaleNotification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import Entities.*;

public class SaleNotificationTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 0,
            0, "www.amazonimage.com/keyboard");

    @Test
    public void TestSaleNotificationReturnsShowNotification() {
        SaleNotification saleNotification = new SaleNotification(plushie);
        saleNotification.startNotificationListener();
        Assertions.assertFalse(saleNotification.getShowNotification());
    }

    @Test
    public void TestSaleNotificationChecksNotificationFalse() {
        SaleNotification saleNotification = new SaleNotification(plushie);
        saleNotification.endNotificationListener();
        Assertions.assertFalse(saleNotification.checkNotification());
    }

    @Test
    public void TestSaleNotificationChecksNotificationTrue() {
        SaleNotification saleNotification = new SaleNotification(plushie);
        plushie.setPriceChange(-1.0);
        Assertions.assertTrue(saleNotification.checkNotification());
    }
}
