package devops.backlogItemState;

import devops.BacklogItem;

public interface SprintBacklogItemState {
    void firstState(BacklogItem backlogItem);
    void nextState(BacklogItem backlogItem);
    void finalState(BacklogItem backlogItem);
}
