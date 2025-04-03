package devops;

import devops.sprintState.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SprintStateTest {
    private Sprint sprint;

    @BeforeEach
    void setUp() {
        sprint = mock(Sprint.class);
    }

    @Test
    void testTransitionFromCreatedToStarted() {
        SprintState createdState = new CreatedState();
        when(sprint.getStatus()).thenReturn("Created");

        createdState.startSprint(sprint);
        verify(sprint).setState(any(StartedState.class));
    }

    @Test
    void testTransitionFromStartedToFinished() {
        SprintState startedState = new StartedState();
        when(sprint.getStatus()).thenReturn("Started");

        startedState.finishSprint(sprint);
        verify(sprint).setState(any(FinishedState.class));
    }

    @Test
    void testTransitionFromFinishedToReviewing() {
        SprintState finishedState = new FinishedState();
        when(sprint.getStatus()).thenReturn("Finished");

        finishedState.startReview(sprint);
        verify(sprint).setState(any(ReviewingState.class));
    }

    @Test
    void testTransitionFromFinishedToReleasing() {
        SprintState finishedState = new FinishedState();
        when(sprint.getStatus()).thenReturn("Finished");

        finishedState.startRelease(sprint);
        verify(sprint).setState(any(ReleasingState.class));
    }

    @Test
    void testInvalidTransitionFromCreatedToReviewing() {
        SprintState createdState = new CreatedState();
        when(sprint.getStatus()).thenReturn("Created");

        createdState.startReview(sprint);
        verify(sprint, never()).setState(any());
    }

    @Test
    void testInvalidTransitionFromReleasingToStarted() {
        SprintState releasingState = new ReleasingState();
        when(sprint.getStatus()).thenReturn("Releasing");

        releasingState.startSprint(sprint);
        verify(sprint, never()).setState(any());
    }
}
