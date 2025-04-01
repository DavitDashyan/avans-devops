package devops;

public class SlackNotificationService implements INotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Slack Notification: " + message);
    }
}
