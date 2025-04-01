package devops;

import devops.observer.IObserver;

public class NotificationManager implements IObserver {
    private final INotificationService notificationService;

    public NotificationManager(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void update() {
        // Handle the update and send notifications
        notificationService.sendNotification("A new event occurred.");
    }
}
