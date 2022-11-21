import java.io.IOException;
import java.util.TimerTask;

public class SaleNotification implements BaseNotification {
    private final Scheduler scheduler;
    private final Item item;
    private Boolean showNotification;

    public SaleNotification(Item item) {
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

    @Override
    public void startNotificationListener() {
        this.scheduler.enableTimer();
    }

    @Override
    public void endNotificationListener() {
        this.scheduler.disableTimer();
    }

    public void checkNotification() {
        this.showNotification = item.isItemOnSale();
    }
}
