package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class CreatedState implements SprintState {
    @Override
    public void startSprint(Sprint sprint) {
        sprint.setState(new StartedState());
        System.out.println("Sprint started.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        sprint.setState(new CanceledState());
        System.out.println("Sprint canceled.");
    }

    @Override
    public void finishSprint(Sprint sprint) {
        System.out.println("Cannot finish a sprint that hasn't started.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Cannot lock a sprint that hasn't started.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        System.out.println("Cannot close a sprint that hasn't started.");
    }

    @Override
    public String getStatus() {
        return "Created";
    }

    @Override
    public void startReview(Sprint sprint) {
        System.out.println("Cannot start review for a sprint that hasn't started.");
    }

    @Override
    public void startRelease(Sprint sprint) {
        System.out.println("Cannot start release for a sprint that hasn't started.");
    }
}
