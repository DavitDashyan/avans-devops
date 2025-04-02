package devops;

import devops.sprintState.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SprintStateTest {
    private Sprint sprint;

    @BeforeEach
    void setUp() {
        sprint = new ReviewSprint();
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
}
