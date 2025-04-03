package devops;

import devops.backlogItemState.SprintBacklogItemState;

public class SubItem {
    private int id;
    private String title;
    private String description;
    private boolean done;
    private Person assignedPerson;
    private BacklogItem parentBacklogItem;
    private SprintBacklogItemState state;

    public SubItem(int id, String title, String description, Person assignedPerson) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignedPerson = assignedPerson;
        this.done = false;
    }

    public void changeState() {
        this.done = !this.done;
    }

    public void getDetails() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Done: " + done);
        System.out.println("Assigned Person: " + assignedPerson);
    }

    public void setParentBacklogItem(BacklogItem parentBacklogItem) {
        this.parentBacklogItem = parentBacklogItem;
    }

    public boolean isDone() {
        return done;
    }

    public SprintBacklogItemState getState() {
        return state;
    }

    public void setState(SprintBacklogItemState state) {
        this.state = state;
    }
}
