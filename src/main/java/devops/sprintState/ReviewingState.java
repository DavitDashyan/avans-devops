package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class ReviewingState implements SprintState {
    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Cannot start a sprint that is under review.");
    }

    @Override
    public void finishSprint(Sprint sprint) {
        System.out.println("Cannot finish a sprint that is under review.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        System.out.println("Cannot cancel a sprint that is under review.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Cannot lock a sprint that is under review.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        sprint.setState(new ClosedState());
        System.out.println("Sprint closed after review.");
    }

    @Override
    public void startReview(Sprint sprint) {
        System.out.println("Sprint is already under review.");
    }

    @Override
    public void startRelease(Sprint sprint) {
        System.out.println("Cannot start release for a sprint that is under review.");
    }

    @Override
    public String getStatus() {
        return "Reviewing";
    }
}
