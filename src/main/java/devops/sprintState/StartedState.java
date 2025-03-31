package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class StartedState implements SprintState {
    @Override
    public void finishSprint(Sprint sprint) {
        sprint.setState(new FinishedState());
        System.out.println("Sprint finished.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        sprint.setState(new CanceledState());
        System.out.println("Sprint canceled.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        sprint.setState(new LockedState());
        System.out.println("Sprint locked.");
    }

    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Sprint is already started.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        System.out.println("Cannot close a sprint that hasn't been finished or locked.");
    }

    @Override
    public String getStatus() {
        return "Started";
    }
}
