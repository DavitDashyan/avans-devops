package devops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscussionTest {
    private Discussion discussion;
    private Thread thread;

    @BeforeEach
    void setUp() {
        discussion = new Discussion();
        thread = new Thread(new BacklogItem(1, "Test Item", "Description", 1));
    }

    @Test
    void testAddThread() {
        discussion.addThread(thread);
        assertTrue(discussion.getThreads().contains(thread));
    }

    @Test
    void testRemoveThread() {
        discussion.addThread(thread);
        discussion.removeThread(thread);
        assertFalse(discussion.getThreads().contains(thread));
    }

    @Test
    void testGetThreads() {
        discussion.addThread(thread);
        assertEquals(1, discussion.getThreads().size());
    }

    @Test
    void testAddNullThread() {
        assertThrows(IllegalArgumentException.class, () -> discussion.addThread(null));
    }
}
