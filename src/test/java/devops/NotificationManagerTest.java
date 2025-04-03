package devops;

import devops.observer.IObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationManagerTest {
    private NotificationManager notificationManager;
    private INotificationService notificationService;

    @BeforeEach
    void setUp() {
        notificationService = mock(INotificationService.class);
        notificationManager = new NotificationManager(notificationService);
    }

    @Test
    void testUpdate() {
        notificationManager.update();
        verify(notificationService).sendNotification("A new event occurred.");
    }

    @Test
    void testNotifyRoles() {
        notificationManager.notifyTesters("Test message");
        verify(notificationService).sendNotification("Notification to Testers: Test message");

        notificationManager.notifyScrumMaster("Scrum Master message");
        verify(notificationService).sendNotification("Notification to Scrum Master: Scrum Master message");

        notificationManager.notifyProductOwner("Product Owner message");
        verify(notificationService).sendNotification("Notification to Product Owner: Product Owner message");
    }
}
