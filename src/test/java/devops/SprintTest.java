package devops;

import devops.sprintState.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SprintTest {
    private Sprint sprint;

    @BeforeEach
    void setUp() {
        sprint = new ReviewSprint();
        sprint.setState(new CreatedState());
    }

    @Test
    void testStartSprint() {
        sprint.startSprint();
        assertTrue(sprint.getState() instanceof StartedState);
    }

    @Test
    void testFinishSprint() {
        sprint.startSprint();
        sprint.finishSprint();
        assertTrue(sprint.getState() instanceof FinishedState);
    }

    @Test
    void testCancelSprint() {
        sprint.cancelSprint();
        assertTrue(sprint.getState() instanceof CanceledState);
    }

    @Test
    void testLockSprint() {
        sprint.startSprint();
        sprint.lockSprint();
        assertTrue(sprint.getState() instanceof LockedState);
    }

    @Test
    void testCloseSprint() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.closeSprint();
        assertTrue(sprint.getState() instanceof ClosedState);
    }

    @Test
    void testStartReview() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startReview();
        assertTrue(sprint.getState() instanceof ReviewingState);
    }

    @Test
    void testStartRelease() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startRelease();
        assertTrue(sprint.getState() instanceof ReleasingState);
    }

    @Test
    void testGetStatus() {
        assertEquals("Created", sprint.getStatus());
        sprint.startSprint();
        assertEquals("Started", sprint.getStatus());
    }

    @Test
    void testGenerateReport() {
        Report report = sprint.generateReport("burndownchart", "pdf");
        assertNotNull(report);
        assertEquals("Generated burndownchart report in PDF format.", report.getContent());
    }

    @Test
    void testInvalidTransitionFromCreatedToClosed() {
        sprint.closeSprint();
        assertFalse(sprint.getState() instanceof ClosedState);
    }

    @Test
    void testInvalidTransitionFromStartedToReviewing() {
        sprint.startSprint();
        sprint.startReview();
        assertFalse(sprint.getState() instanceof ReviewingState);
    }

    @Test
    void testInvalidTransitionFromFinishedToStarted() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startSprint();
        assertFalse(sprint.getState() instanceof StartedState);
    }

    @Test
    void testCancelSprintFromCreatedState() {
        sprint.cancelSprint();
        assertTrue(sprint.getState() instanceof CanceledState);
    }

    @Test
    void testLockSprintFromStartedState() {
        sprint.startSprint();
        sprint.lockSprint();
        assertTrue(sprint.getState() instanceof LockedState);
    }

    @Test
    void testCloseSprintFromReviewingState() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startReview();
        sprint.closeSprint();
        assertTrue(sprint.getState() instanceof ClosedState);
    }

    @Test
    void testStartReleaseFromFinishedState() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startRelease();
        assertTrue(sprint.getState() instanceof ReleasingState);
    }

    @Test
    void testInvalidTransitionFromReleasingToReviewing() {
        sprint.startSprint();
        sprint.finishSprint();
        sprint.startRelease();
        sprint.startReview();
        assertFalse(sprint.getState() instanceof ReviewingState);
    }

    @Test
    void testGetStatusForEachState() {
        assertEquals("Created", sprint.getStatus());
        sprint.startSprint();
        assertEquals("Started", sprint.getStatus());
        sprint.finishSprint();
        assertEquals("Finished", sprint.getStatus());
        sprint.startReview();
        assertEquals("Reviewing", sprint.getStatus());
        sprint.closeSprint();
        assertEquals("Closed", sprint.getStatus());
    }

    @Test
    void testInvalidTransitionFromCreatedToLocked() {
        sprint.lockSprint();
        assertFalse(sprint.getState() instanceof LockedState);
    }

    @Test
    void testInvalidTransitionFromStartedToClosed() {
        sprint.startSprint();
        sprint.closeSprint();
        assertFalse(sprint.getState() instanceof ClosedState);
    }

    @Test
    void testInvalidTransitionFromLockedToStarted() {
        sprint.startSprint();
        sprint.lockSprint();
        sprint.startSprint();
        assertFalse(sprint.getState() instanceof StartedState);
    }

    @Test
    void testGenerateReportInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sprint.generateReport("invalidType", "pdf");
        });
        assertEquals("Invalid report type: invalidType", exception.getMessage());
    }

    @Test
    void testGenerateReportInvalidFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sprint.generateReport("burndownchart", "invalidFormat");
        });
        assertEquals("Invalid format: invalidFormat", exception.getMessage());
    }

    @Test
    void testStartPipelineBeforeSprintFinished() {
        Pipeline pipeline = new Pipeline();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            sprint.startPipeline(pipeline);
        });
        assertEquals("Pipeline can only be started after the sprint is finished.", exception.getMessage());
    }
}