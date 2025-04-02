package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class LockedState implements SprintState {
    @Override
    public void finishSprint(Sprint sprint) {
        sprint.setState(new FinishedState());
        System.out.println("Sprint finished.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        sprint.setState(new ClosedState());
        System.out.println("Sprint closed.");
    }

    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Cannot start a sprint that is locked.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        System.out.println("Cannot cancel a sprint that is locked.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Sprint is already locked.");
    }

    @Override
    public String getStatus() {
        return "Locked";
    }

    @Override
    public void startReview(Sprint sprint) {
        System.out.println("Cannot start review for a sprint that is locked.");
    }

    @Override
    public void startRelease(Sprint sprint) {
        System.out.println("Cannot start release for a sprint that is locked.");
    }
}
