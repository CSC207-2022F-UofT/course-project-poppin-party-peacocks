package Controller;

public class PriceDropNotification implements BaseNotification {
    private Scheduler scheduler;
    public PriceDropNotification(Scheduler scheduler) {
        this.scheduler = scheduler;
    }
    @Override
    public void startNotificationListener() {
        this.scheduler.enableTimer();
    }

    @Override
    public void endNotificationListener() {
        this.scheduler.disableTimer();
    }
}
