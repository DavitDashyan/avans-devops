package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class FinishedState implements SprintState {
    @Override
    public void closeSprint(Sprint sprint) {
        sprint.setState(new ClosedState());
        System.out.println("Sprint closed.");
    }

    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Cannot start a sprint that is already finished.");
    }

    @Override
    public void finishSprint(Sprint sprint) {
        System.out.println("Sprint is already finished.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        System.out.println("Cannot cancel a sprint that is already finished.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Cannot lock a sprint that is already finished.");
    }

    @Override
    public String getStatus() {
        return "Finished";
    }
}
