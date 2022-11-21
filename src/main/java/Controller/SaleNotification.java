package Controller;

public class SaleNotification implements BaseNotification {
    private Scheduler scheduler;
    public SaleNotification(Scheduler scheduler) {
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
