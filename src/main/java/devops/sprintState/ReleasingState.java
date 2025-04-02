package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class ReleasingState implements SprintState {
    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Cannot start a sprint that is being released.");
    }

    @Override
    public void finishSprint(Sprint sprint) {
        System.out.println("Cannot finish a sprint that is being released.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        sprint.setState(new CanceledState());
        System.out.println("Release canceled. Sprint marked as canceled.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Cannot lock a sprint that is being released.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        System.out.println("Cannot close a sprint that is being released.");
    }

    @Override
    public void startReview(Sprint sprint) {
        System.out.println("Cannot start review for a sprint that is being released.");
    }

    @Override
    public void startRelease(Sprint sprint) {
        System.out.println("Sprint is already being released.");
    }

    @Override
    public String getStatus() {
        return "Releasing";
    }
}
