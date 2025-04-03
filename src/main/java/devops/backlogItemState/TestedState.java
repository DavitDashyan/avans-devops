package devops.backlogItemState;

import devops.BacklogItem;

public class TestedState implements SprintBacklogItemState {
    @Override
    public void firstState(BacklogItem backlogItem) {
        System.out.println("Invalid transition: Cannot move directly from Tested to ToDo state.");
    }

    @Override
    public void nextState(BacklogItem backlogItem) {
        backlogItem.setState(new DoneState());
        System.out.println("BacklogItem moved to Done state.");
    }

    @Override
    public void finalState(BacklogItem backlogItem) {
        System.out.println("Cannot directly move to final state from Tested.");
    }

    public void backToReadyForTesting(BacklogItem backlogItem) {
        backlogItem.setState(new ReadyForTestingState());
        System.out.println("BacklogItem moved to ReadyForTesting state.");
    }
}
