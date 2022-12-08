package UseCases.Notification;
import Controller.Scheduler;
import Entities.*;
import ExternalInterface.ItemUpdateChecker;

import java.io.IOException;
import java.util.TimerTask;

/** A price drop notification use case that tells us if a product drops below the user's desired price */
public class PriceDropNotification implements BaseNotification {

    /** A scheduler for timing tasks */
    private final Scheduler scheduler;
    /** The product of the notification */
    private final Product product;
    /** Whether notification should be shown or not */
    private boolean showNotification;
    public PriceDropNotification(Product product, TimerTask timerTask) {
        this.showNotification = false;
        this.scheduler = new Scheduler(timerTask, 1000 * 60);
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

    /** Logic to check if price drop notification should be seen
     * @returns boolean if notification should be shown */
    public boolean checkNotification() {
        this.showNotification = this.product.getProductPrice() < this.product.getProductDesiredPrice();
        return this.showNotification;
    }
}
