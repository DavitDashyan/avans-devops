package devops;

import java.util.ArrayList;
import java.util.List;

public class ProjectBacklog {
    private Project project;
    private List<BacklogItem> backlogItems;

    public ProjectBacklog(Project project) {
        this.project = project;
        this.backlogItems = new ArrayList<>();
    }

    public void addBacklogItem(BacklogItem item) {
        backlogItems.add(item);
    }

    public void removeBacklogItem(BacklogItem item) {
        backlogItems.remove(item);
    }

    public List<BacklogItem> getBacklogItems() {
        return backlogItems;
    }

    public void getBacklog() {
        for (BacklogItem item : backlogItems) {
            System.out.println(item);
        }
    }
}
