package devops;

import java.util.List;

import devops.backlogItemState.SprintBacklogItemState;
import devops.backlogItemState.ToDoState;
import devops.backlogItemState.ReadyForTestingState;

public class BacklogItem {
    private int id;
    private String title;
    private String description;
    private int priority;
    private Persoon developer;
    private List<SubItem> subItems;
    private SprintBacklogItemState sprintBacklogItemState;
    private boolean inSprintBacklog;
    private SprintBacklogItemState state = new ToDoState();

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
}
