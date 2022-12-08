package UseCasesTest.Notification;

import Entities.Item;
import UseCases.Notification.SaleNotification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.TimerTask;

public class SaleNotificationTest {
    Item plushie = new Item("Plushie", 40.99, 30.00, "https://www.amazon.ca/Quest-Nutrition-Protein-Chocolate-Cookie/dp/B01FLQCMZ8/?_encoding=UTF8&pd_rd_w=Qs8nA&content-id=amzn1.sym.b09e9731-f0de-43db-b62a-8954bcec282c&pf_rd_p=b09e9731-f0de-43db-b62a-8954bcec282c&pf_rd_r=KQ9YFXZ0Y0V8D5NNYWP4&pd_rd_wg=KCeX3&pd_rd_r=c3756a52-c66f-4279-a5ac-a6c974d1d8fa&ref_=pd_gw_ci_mcx_mr_hp_atf_m",
            "Description from amazon (or you write your own)", new String[]{"toys"}, 0,
            0, "www.amazonimage.com/keyboard");

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            // pass
        }
    };

    @Test
    public void TestSaleNotificationReturnsShowNotification() {
        SaleNotification saleNotification = new SaleNotification(plushie, timerTask);
        saleNotification.startNotificationListener();
        Assertions.assertFalse(saleNotification.getShowNotification());
    }

    @Test
    public void TestSaleNotificationChecksNotificationFalse() {
        SaleNotification saleNotification = new SaleNotification(plushie, timerTask);
        saleNotification.endNotificationListener();
        Assertions.assertFalse(saleNotification.checkNotification());
    }

    @Test
    public void TestSaleNotificationChecksNotificationTrue() {
        SaleNotification saleNotification = new SaleNotification(plushie, timerTask);
        plushie.setPriceChange(-1.0);
        Assertions.assertTrue(saleNotification.checkNotification());
    }

    @Test
    public void TestSaleNotificationChecksNotificationActionTrue() throws IOException {
        SaleNotification saleNotification = new SaleNotification(plushie, timerTask);
        plushie.setPriceChange(-1.0);
        Assertions.assertTrue(saleNotification.checkNotificationAction());
    }
}
