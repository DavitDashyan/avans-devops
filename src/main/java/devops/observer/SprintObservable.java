package devops.observer;

import devops.SprintState;
import java.util.ArrayList;
import java.util.List;

public class SprintObservable {
    private SprintState sprintState;
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

    public void setSprintState(SprintState sprintState) {
        this.sprintState = sprintState;
        setChanged();
        notifyObservers();
    }

    public SprintState getSprintState() {
        return sprintState;
    }
}
