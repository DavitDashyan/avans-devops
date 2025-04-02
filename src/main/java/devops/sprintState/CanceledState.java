package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class CanceledState implements SprintState {
    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Cannot start a sprint that is canceled.");
    }

    @Override
    public void finishSprint(Sprint sprint) {
        System.out.println("Cannot finish a sprint that is canceled.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        System.out.println("Sprint is already canceled.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Cannot lock a sprint that is canceled.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        System.out.println("Cannot close a sprint that is canceled.");
    }

    @Override
    public String getStatus() {
        return "Canceled";
    }

    @Override
    public void startReview(Sprint sprint) {
        System.out.println("Cannot start review for a sprint that is canceled.");
    }

    @Override
    public void startRelease(Sprint sprint) {
        System.out.println("Cannot start release for a sprint that is canceled.");
    }
}
