package devops;

public interface SprintState {
    void startSprint(Sprint sprint);
    void finishSprint(Sprint sprint);
    void cancelSprint(Sprint sprint);
    void lockSprint(Sprint sprint);
    void closeSprint(Sprint sprint);
    String getStatus();
}
