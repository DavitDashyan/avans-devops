package devops;

import java.util.List;

public class SprintBacklog {
    private int id;
    private Sprint sprint;
    private List<BacklogItem> backlogItems;

    public void addBacklogItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public void deleteBacklogItem(BacklogItem item) {
        backlogItems.remove(item);
    }

    public void getSprintBacklog() {
        for (BacklogItem item : backlogItems) {
            System.out.println(item);
        }
    }
}
