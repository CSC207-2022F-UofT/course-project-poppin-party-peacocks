package UseCases.Notification;

interface BaseNotification {
    /** Starts a notification schedule */
    public void startNotificationListener();
    /** Ends a notification schedule */
    public void endNotificationListener();
    /** Logic for checking if notification was valid
     * @returns boolean that checks if notification was valid */
    public boolean checkNotification();
}