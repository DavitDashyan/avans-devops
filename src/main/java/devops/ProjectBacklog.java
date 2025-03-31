package devops;

import java.util.List;

public class ProjectBacklog {
    private Project project;
    private List<BacklogItem> backlogItems;

    public void addBacklogItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public void removeBacklogItem(BacklogItem item) {
        backlogItems.remove(item);
    }

    public void getBacklog() {
        for (BacklogItem item : backlogItems) {
            System.out.println(item);
        }
    }
}
