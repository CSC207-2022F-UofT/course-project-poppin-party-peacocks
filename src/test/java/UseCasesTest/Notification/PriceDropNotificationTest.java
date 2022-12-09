package UseCasesTest.Notification;

import Entities.Item;
import UseCases.Notification.PriceDropNotification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class PriceDropNotificationTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "https://www.amazon.ca/Quest-Nutrition-Protein-Chocolate-Cookie/dp/B01FLQCMZ8/?_encoding=UTF8&pd_rd_w=Qs8nA&content-id=amzn1.sym.b09e9731-f0de-43db-b62a-8954bcec282c&pf_rd_p=b09e9731-f0de-43db-b62a-8954bcec282c&pf_rd_r=KQ9YFXZ0Y0V8D5NNYWP4&pd_rd_wg=KCeX3&pd_rd_r=c3756a52-c66f-4279-a5ac-a6c974d1d8fa&ref_=pd_gw_ci_mcx_mr_hp_atf_m",
            "Description from amazon (or you write your own)", 0,
            0, "www.amazonimage.com/keyboard");

    @Test
    public void TestPriceDropNotificationReturnsShowNotification() {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        priceDropNotification.startNotificationListener();
        Assertions.assertFalse(priceDropNotification.getShowNotification());
    }

    @Test
    public void TestPriceDropNotificationChecksNotificationFalse() {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        priceDropNotification.endNotificationListener();
        Assertions.assertFalse(priceDropNotification.checkNotification());
    }

    @Test
    public void TestPriceDropNotificationChecksNotificationTrue() {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        plushie.setDesiredPrice(50.00);
        Assertions.assertTrue(priceDropNotification.checkNotification());
    }

    @Test
    public void TestPriceDropNotificationChecksNotificationActionTrue() throws IOException {
        PriceDropNotification priceDropNotification = new PriceDropNotification(plushie);
        plushie.setDesiredPrice(50.00);
        Assertions.assertTrue(priceDropNotification.checkNotificationAction());
    }
}
