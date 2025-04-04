package devops;

import devops.backlogItemState.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BacklogItemTest {
    private BacklogItem backlogItem;

    @BeforeEach
    void setUp() {
        backlogItem = new BacklogItem(1, "Test Backlog Item", "This is a test backlog item.", 1);
    }

    @Test
    void testInitialStateIsToDo() {
        assertTrue(backlogItem.getState() instanceof ToDoState);
    }

    @Test
    void testTransitionFromToDoToDoing() {
        backlogItem.moveToNextState();
        assertTrue(backlogItem.getState() instanceof DoingState);
    }

    @Test
    void testTransitionFromDoingToReadyForTesting() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        assertTrue(backlogItem.getState() instanceof ReadyForTestingState);
    }

    @Test
    void testTransitionFromReadyForTestingToTesting() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToNextState(); // To Testing
        assertTrue(backlogItem.getState() instanceof TestingState);
    }

    @Test
    void testTransitionFromTestingToTested() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToNextState(); // To Testing
        backlogItem.moveToNextState(); // To Tested
        assertTrue(backlogItem.getState() instanceof TestedState);
    }

    @Test
    void testTransitionFromTestedToDone() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToNextState(); // To Testing
        backlogItem.moveToNextState(); // To Tested
        backlogItem.moveToNextState(); // To Done
        assertTrue(backlogItem.getState() instanceof DoneState);
    }

    @Test
    void testTransitionFromReadyForTestingBackToToDo() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToFirstState(); // Back to ToDo
        assertTrue(backlogItem.getState() instanceof ToDoState);
    }

    @Test
    void testTransitionFromTestedBackToReadyForTesting() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToNextState(); // To Testing
        backlogItem.moveToNextState(); // To Tested
        ((TestedState) backlogItem.getState()).backToReadyForTesting(backlogItem);
        assertTrue(backlogItem.getState() instanceof ReadyForTestingState);
    }

    @Test
    void testCannotTransitionFromDoingToFinalState() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToFinalState(); // Invalid transition
        assertTrue(backlogItem.getState() instanceof DoingState);
    }

    @Test
    void testCannotTransitionFromReadyForTestingToDoneDirectly() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToFinalState(); // Invalid transition
        assertTrue(backlogItem.getState() instanceof ReadyForTestingState);
    }

    @Test
    void testInvalidTransitionFromTestedToToDo() {
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToNextState(); // To Testing
        backlogItem.moveToNextState(); // To Tested

        backlogItem.moveToFirstState(); // Invalid transition
        assertFalse(backlogItem.getState() instanceof ToDoState);
    }

    @Test
    void testReturnNumberEight() {
        BacklogItem backlogItem = new BacklogItem(1, "Test", "Description", 1);
        assertEquals(8, backlogItem.returnNumberEight(), "The method should return 8");
    }
}
