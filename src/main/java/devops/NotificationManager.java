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

    public void notifyTesters(String message) {
        notificationService.sendNotification("Notification to Testers: " + message);
    }

    public void notifyScrumMaster(String message) {
        notificationService.sendNotification("Notification to Scrum Master: " + message);
    }

    public void notifyProductOwner(String message) {
        notificationService.sendNotification("Notification to Product Owner: " + message);
    }
}
