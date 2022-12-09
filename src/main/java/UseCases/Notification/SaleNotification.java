package UseCases.Notification;
import Controller.Scheduler;
import Entities.*;
import ExternalInterface.ItemUpdateChecker;

import java.io.IOException;
import java.util.TimerTask;

/** A sale notification use case that tells us if a product is on sale */
public class SaleNotification implements BaseNotification {
    /** A scheduler for timing tasks */
    private final Scheduler scheduler;
    /** The product of the notification */
    private final Product product;
    /** Whether notification should be shown or not */
    private boolean showNotification;

    public SaleNotification(Product product) {
        this.showNotification = false;
        TimerTask checkSale = new TimerTask() {
            @Override
            public void run() {
                try {
                    checkNotificationAction();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
    public boolean checkNotificationAction() throws IOException {
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

