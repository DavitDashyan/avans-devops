package devops.backlogItemState;

import devops.BacklogItem;

public class DoneState implements SprintBacklogItemState {
    @Override
    public void firstState(BacklogItem backlogItem) {
        backlogItem.setState(new ToDoState());
        System.out.println("BacklogItem moved back to ToDo state.");
    }

    @Override
    public void nextState(BacklogItem backlogItem) {
        System.out.println("BacklogItem is already in Done state.");
    }

    @Override
    public void finalState(BacklogItem backlogItem) {
        System.out.println("BacklogItem is already in final state (Done).");
    }
}
