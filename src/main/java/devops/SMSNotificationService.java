package devops;

public class SMSNotificationService implements INotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification: " + message);
    }
}
