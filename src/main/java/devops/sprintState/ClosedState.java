package devops.sprintState;

import devops.Sprint;
import devops.SprintState;

public class ClosedState implements SprintState {
    @Override
    public void startSprint(Sprint sprint) {
        System.out.println("Cannot start a sprint that is closed.");
    }

    @Override
    public void finishSprint(Sprint sprint) {
        System.out.println("Cannot finish a sprint that is closed.");
    }

    @Override
    public void cancelSprint(Sprint sprint) {
        System.out.println("Cannot cancel a sprint that is closed.");
    }

    @Override
    public void lockSprint(Sprint sprint) {
        System.out.println("Cannot lock a sprint that is closed.");
    }

    @Override
    public void closeSprint(Sprint sprint) {
        System.out.println("Sprint is already closed.");
    }

    @Override
    public String getStatus() {
        return "Closed";
    }
}
