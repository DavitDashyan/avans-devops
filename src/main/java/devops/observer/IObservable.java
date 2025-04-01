package devops.observer;

public interface IObservable {
    void addObserver(IObserver observer);
    void deleteObserver(IObserver observer);
    void notifyObservers(String message);
}
