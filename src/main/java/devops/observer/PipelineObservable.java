package devops.observer;

import java.util.ArrayList;
import java.util.List;

public class PipelineObservable implements IObservable {
    private final List<IObserver> observers = new ArrayList<>();
    private boolean changed = false;

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
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

    public void pipelineEvent(String message) {
        setChanged();
        notifyObservers(message);
    }
}
