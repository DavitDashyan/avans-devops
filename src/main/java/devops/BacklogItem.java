package devops;

import java.util.ArrayList;
import java.util.List;

import devops.backlogItemState.SprintBacklogItemState;
import devops.backlogItemState.ToDoState;
import devops.backlogItemState.ReadyForTestingState;

public class BacklogItem {
    private int id;
    private String title;
    private String description;
    private int priority;
    private Person developer;
    private List<SubItem> subItems = new ArrayList<>();
    private SprintBacklogItemState state = new ToDoState();
    private boolean inSprintBacklog;

    public BacklogItem(int id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void addSubitem(SubItem subItem, BacklogItem backlogItem) {
        subItems.add(subItem);
        subItem.setParentBacklogItem(backlogItem);
    }

    public void getDetails() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        System.out.println("Developer: " + developer);
        System.out.println("In Sprint Backlog: " + inSprintBacklog);
        System.out.println("SubItems: " + subItems);
    }

    public boolean isStateEqualToReadyForTesting() {
        return state instanceof ReadyForTestingState;
    }

    public void setState(SprintBacklogItemState state) {
        this.state = state;
    }

    public void moveToFirstState() {
        state.firstState(this);
    }

    public void moveToNextState() {
        state.nextState(this);
    }

    public void moveToFinalState() {
        state.finalState(this);
    }

    public SprintBacklogItemState getState() {
        return state;
    }

    public void setDeveloper(Person developer) {
        this.developer = developer;
    }

    public Person getDeveloper() {
        return developer;
    }

    public List<SubItem> getSubItems() {
        return subItems;
    }
}
