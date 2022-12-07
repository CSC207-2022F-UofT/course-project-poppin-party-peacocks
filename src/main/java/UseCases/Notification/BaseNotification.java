package UseCases.Notification;

/** An interface defining common methods for price notifications */
interface BaseNotification {
    /** Starts a notification schedule */
    void startNotificationListener();
    /** Ends a notification schedule */
    void endNotificationListener();
    /** Logic for checking if notification was valid
     * @returns boolean that checks if notification was valid */
    boolean checkNotification();
    /** Updates item from amazon and calls check logic
     * @returns whether notification should be shown */
    boolean checkNotificationAction();
}
