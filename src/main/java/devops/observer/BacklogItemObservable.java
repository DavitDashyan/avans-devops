package devops.observer;

import devops.backlogItemState.SprintBacklogItemState;
import java.util.ArrayList;
import java.util.List;

public class BacklogItemObservable {
    private SprintBacklogItemState backlogState;
    private final List<IObserver> observers = new ArrayList<>();
    private boolean changed = false;

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void deleteObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        if (changed) {
            for (IObserver observer : observers) {
                observer.update();
            }
            changed = false;
        }
    }

    public void setChanged() {
        this.changed = true;
    }

    public void setBacklogState(SprintBacklogItemState backlogState) {
        this.backlogState = backlogState;
        setChanged();
        notifyObservers();
    }

    public SprintBacklogItemState getBacklogState() {
        return backlogState;
    }
}
