package Controller;

public class SaleNotification implements BaseNotification {
    private boolean onSale;

    public SaleNotification(boolean onSale) {
        this.onSale = onSale;
    }
    @Override
    public void startNotificationListener() {

    }

    @Override
    public void endNotificationListener() {

    }
}
