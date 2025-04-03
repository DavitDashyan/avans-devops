package devops;

import devops.sprintState.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SprintStateTest {
    private Sprint sprint;
    private StartedState startedState;

    @BeforeEach
    void setUp() {
        sprint = mock(Sprint.class);
        startedState = new StartedState();
    }

    @Test
    void testFinishSprint() {
        startedState.finishSprint(sprint);
        verify(sprint).setState(any(FinishedState.class));
    }

    @Test
    void testCancelSprint() {
        startedState.cancelSprint(sprint);
        verify(sprint).setState(any(CanceledState.class));
    }

    @Test
    void testLockSprint() {
        startedState.lockSprint(sprint);
        verify(sprint).setState(any(LockedState.class));
    }

    @Test
    void testStartSprint() {
        startedState.startSprint(sprint);
        verify(sprint, never()).setState(any());
    }

    @Test
    void testTransitionFromCreatedToStarted() {
        assertEquals("Created", sprint.getStatus());
        sprint.startSprint();
        assertEquals("Started", sprint.getStatus());
    }

    @Test
    void testTransitionFromStartedToFinished() {
        sprint.startSprint();
        sprint.finishSprint();
        assertEquals("Finished", sprint.getStatus());
    }

    @Test
    void testTransitionFromFinishedToReviewing() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startReview();
        assertEquals("Reviewing", sprint.getStatus());
    }

    @Test
    void testTransitionFromFinishedToReleasing() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startRelease();
        assertEquals("Releasing", sprint.getStatus());
    }

    @Test
    void testInvalidTransitionFromCreatedToReviewing() {
        assertEquals("Created", sprint.getStatus());
        sprint.startReview();
        assertEquals("Created", sprint.getStatus());
    }

    @Test
    void testInvalidTransitionFromReleasingToStarted() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startRelease();
        sprint.startSprint();
        assertEquals("Releasing", sprint.getStatus());
    }

    @Test
    void testLockedStateTransitions() {
        SprintState lockedState = new LockedState();

        lockedState.finishSprint(sprint);
        verify(sprint).setState(any(FinishedState.class));

        lockedState.closeSprint(sprint);
        verify(sprint).setState(any(ClosedState.class));

        lockedState.startSprint(sprint);
        verify(sprint, never()).setState(any());
    }

    @Test
    void testFinishedStateTransitions() {
        SprintState finishedState = new FinishedState();

        finishedState.startReview(sprint);
        verify(sprint).setState(any(ReviewingState.class));

        finishedState.startRelease(sprint);
        verify(sprint).setState(any(ReleasingState.class));

        finishedState.closeSprint(sprint);
        verify(sprint).setState(any(ClosedState.class));
    }

    @Test
    void testReleasingStateInvalidTransitions() {
        SprintState releasingState = new ReleasingState();

        releasingState.startSprint(sprint);
        verify(sprint, never()).setState(any());

        releasingState.finishSprint(sprint);
        verify(sprint, never()).setState(any());
    }
}
