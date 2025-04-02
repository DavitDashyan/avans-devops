package devops;

import java.util.ArrayList;
import java.util.List;

public class SprintBacklog {
    private int id;
    private Sprint sprint;
    private List<BacklogItem> backlogItems;

    public SprintBacklog(Sprint sprint) {
        this.sprint = sprint;
        this.backlogItems = new ArrayList<>();
    }

    public void addBacklogItem(BacklogItem item, Person developer) {
        if (sprint.getStatus().equals("Started")) {
            throw new IllegalStateException("Cannot add backlog items to a sprint that has already started.");
        }
        if (item.getDeveloper() == null) {
            item.setDeveloper(developer);
            backlogItems.add(item);
        } else {
            throw new IllegalStateException("Backlog item already has a developer assigned.");
        }
    }

    public void deleteBacklogItem(BacklogItem item) {
        if (sprint.getStatus().equals("Started")) {
            throw new IllegalStateException("Cannot remove backlog items from a sprint that has already started.");
        }
        backlogItems.remove(item);
    }

    public void getSprintBacklog() {
        for (BacklogItem item : backlogItems) {
            System.out.println(item);
        }
    }

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }
}
