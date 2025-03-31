package devops.backlogItemState;

import devops.BacklogItem;

public class ToDoState implements SprintBacklogItemState {
    @Override
    public void firstState(BacklogItem backlogItem) {
        System.out.println("BacklogItem is already in ToDo state.");
    }

    @Override
    public void nextState(BacklogItem backlogItem) {
        backlogItem.setState(new DoingState());
        System.out.println("BacklogItem moved to Doing state.");
    }

    @Override
    public void finalState(BacklogItem backlogItem) {
        System.out.println("Cannot directly move to final state from ToDo.");
    }
}
