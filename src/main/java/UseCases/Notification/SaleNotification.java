package UseCases.Notification;
import Controller.Scheduler;
import Entities.*;
import ExternalInterface.ItemUpdateChecker;

import java.io.IOException;
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
                ItemUpdateChecker itemUpdateChecker = new ItemUpdateChecker();
                itemUpdateChecker.updatePriceCheck(product);
                checkNotification();
            }
        };

        this.scheduler = new Scheduler(checkSale, 1000 * 60 * 60 * 24);
        this.product = product;
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
        return this.showNotification;
    }
}
