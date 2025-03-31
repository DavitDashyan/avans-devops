package devops.backlogItemState;

import devops.BacklogItem;

public class TestingState implements SprintBacklogItemState {
    @Override
    public void firstState(BacklogItem backlogItem) {
        backlogItem.setState(new ToDoState());
        System.out.println("BacklogItem moved back to ToDo state.");
    }

    @Override
    public void nextState(BacklogItem backlogItem) {
        backlogItem.setState(new TestedState());
        System.out.println("BacklogItem moved to Tested state.");
    }

    @Override
    public void finalState(BacklogItem backlogItem) {
        System.out.println("Cannot directly move to final state from Testing.");
    }
}
