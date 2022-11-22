package Controller;
import Entities.*;
import java.io.IOException;
import java.util.TimerTask;

public class SaleNotification implements BaseNotification {
    private final Scheduler scheduler;
    private final Item item;
    private Boolean showNotification;

    public SaleNotification(Item item) {
        this.showNotification = Boolean.FALSE;
        TimerTask checkSale = new TimerTask() {
            @Override
            public void run() {
                try {
                    item.updatePrice();
                    checkNotification();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        this.scheduler = new Scheduler(checkSale, 1000 * 60 * 60 * 24);
        this.item = item;
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

    /** Logic to check if sale notification should be seen */
    public boolean checkNotification() {
        this.showNotification = item.isItemOnSale();
        return this.showNotification;
    }
}
