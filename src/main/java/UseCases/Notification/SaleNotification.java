package UseCases.Notification;
import Controller.Scheduler;
import Entities.*;
import ExternalInterface.ItemUpdateChecker;

import java.util.TimerTask;

/** A sale notification use case that tells us if a product is on sale */
public class SaleNotification implements BaseNotification {
    private final Scheduler scheduler;
    private final Product product;
    private Boolean showNotification;

    public SaleNotification(Product product) {
        this.showNotification = Boolean.FALSE;
        TimerTask checkSale = new TimerTask() {
            @Override
            public void run() {
                checkNotificationAction();
            }
        };

        // 1000 * 60 * 60 * 24
        this.scheduler = new Scheduler(checkSale, 1000);
        this.product = product;
    }

    public Boolean checkNotificationAction() {
        ItemUpdateChecker itemUpdateChecker = new ItemUpdateChecker();
        itemUpdateChecker.updatePriceCheck(this.product);
        // return checkNotification();
        System.out.println("HHELLO");
        return Boolean.TRUE;
    }

    public Boolean getShowNotification() {
        return showNotification;
    }

    /** Starts scheduler */
    @Override
    public void startNotificationListener() {
        this.scheduler.enableTimer();
    }

    /** Ends scheduler */
    @Override
    public void endNotificationListener() {
        this.scheduler.disableTimer();
    }

    /** Logic to check if sale notification should be seen
     * @returns boolean if notification should be shown */
    public boolean checkNotification() {
        this.showNotification = product.getPriceChange() < 0;
        System.out.println(product.getPriceChange());
        return this.showNotification;
    }
}
