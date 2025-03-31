package devops;

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

    public void addMessage(Message message) {
        if (!locked && !backlogItem.isStateEqualToReadyForTesting()) {
            messages.add(message);
        } else {
            throw new IllegalStateException("Cannot add messages to a locked thread or a completed backlog item.");
        }
    }

    public void removeMessage(Message message) {
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
}
