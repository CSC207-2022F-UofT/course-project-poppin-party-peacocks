package UseCases.Notification;
import Controller.Scheduler;
import Entities.*;
import ExternalInterface.ItemUpdateChecker;

import java.util.TimerTask;

/** A sale notification use case that tells us if a product is on sale */
public class SaleNotification implements BaseNotification {
    private final Scheduler scheduler;
    private final Product product;
    private boolean showNotification;

    public SaleNotification(Product product) {
        this.showNotification = false;
        TimerTask checkSale = new TimerTask() {
            @Override
            public void run() {
                checkNotificationAction();
            }
        };

        this.scheduler = new Scheduler(checkSale, 1000 * 60);
        this.product = product;
    }

    public boolean getShowNotification() {
        return showNotification;
    }

    /** Updates item from amazon and calls check logic
     * @returns whether notification should be shown */
    public boolean checkNotificationAction() {
        ItemUpdateChecker itemUpdateChecker = new ItemUpdateChecker();
        itemUpdateChecker.updatePriceCheck(this.product);
        return checkNotification();
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
        return this.showNotification;
    }
}
