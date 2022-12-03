package UseCases.Notification;
import Controller.Scheduler;
import Entities.*;
import java.util.TimerTask;

/** A price drop notification use case that tells us if a product drops below the user's desired price */
public class PriceDropNotification implements BaseNotification {
    private final Scheduler scheduler;
    private final Product product;
    private Boolean showNotification;
    public PriceDropNotification(Product product) {
        this.showNotification = Boolean.FALSE;
        TimerTask checkSale = new TimerTask() {
            @Override
            public void run() {
                // TODO: Add refactored item search api call
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

    /** Logic to check if price drop notification should be seen
     * @returns boolean if notification should be shown */
    public boolean checkNotification() {
        this.showNotification = this.product.getProductPrice() <= this.product.getProductDesiredPrice();
        return this.showNotification;
    }
}
