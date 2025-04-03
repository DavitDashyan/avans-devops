package devops;

import devops.backlogItemState.DoneState; // Import the DoneState class
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Thread {
    private int id;
    private String title;
    private Date creationDate;
    private List<Message> messages = new ArrayList<>();
    private boolean locked;
    private BacklogItem backlogItem;

    public Thread(BacklogItem backlogItem) {
        if (backlogItem == null) {
            throw new IllegalArgumentException("BacklogItem cannot be null.");
        }
        this.backlogItem = backlogItem;
    }

    public void addMessage(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }
        if (!locked && !backlogItem.isStateEqualToReadyForTesting()) {
            messages.add(message);
        } else {
            throw new IllegalStateException("Cannot add messages to a locked thread or a completed backlog item.");
        }
    }

    public void removeMessage(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null.");
        }
        if (!locked && !backlogItem.isStateEqualToReadyForTesting()) {
            messages.remove(message);
        } else {
            throw new IllegalStateException("Cannot remove messages from a locked thread or a completed backlog item.");
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void lockThread() {
        this.locked = true;
    }

    public void unlockThread() {
        if (!backlogItem.isStateEqualToReadyForTesting()) {
            this.locked = false;
        } else {
            throw new IllegalStateException("Cannot unlock a thread for a completed backlog item.");
        }
    }

    public void lockIfBacklogItemDone() {
        if (backlogItem.getState() instanceof DoneState) {
            lockThread();
            System.out.println("Thread locked as the associated backlog item is marked as Done.");
        }
    }

    public void unlockIfBacklogItemNotDone() {
        if (!(backlogItem.getState() instanceof DoneState)) {
            unlockThread();
            System.out.println("Thread unlocked as the associated backlog item is no longer marked as Done.");
        }
    }
}
