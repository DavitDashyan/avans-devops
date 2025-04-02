package devops;

import devops.observer.IObserver;

public class NotificationManager implements IObserver {
    private final INotificationService notificationService;

    public NotificationManager(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void update() {
        notificationService.sendNotification("A new event occurred.");
    }
}
