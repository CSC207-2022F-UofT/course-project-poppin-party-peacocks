import Controller.PriceDropNotification;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import Entities.*;

public class PriceDropNotificationTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "www.amazon.com/plushie",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 0,
            0, "www.amazonimage.com/keyboard");

    @Test
    public void TestPriceDropNotificationReturnsShowNotification() {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        Assertions.assertFalse(priceDropNotification.getShowNotification());
    }

    @Test
    public void TestPriceDropNotificationChecksNotificationFalse() {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        Assertions.assertFalse(priceDropNotification.checkNotification());
    }

    @Test
    public void TestPriceDropNotificationChecksNotificationTrue() {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        plushie.setDesiredPrice(10.00);
        Assertions.assertTrue(priceDropNotification.checkNotification());
    }
}