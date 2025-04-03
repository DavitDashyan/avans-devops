package devops;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Discussion {
    private int id;
    private String title;
    private Date creationDate;
    private List<Thread> threads = new ArrayList<>();

    public void addThread(Thread thread) {
        if (thread == null) {
            throw new IllegalArgumentException("Thread cannot be null.");
        }
        threads.add(thread);
    }

    public void removeThread(Thread thread) {
        threads.remove(thread);
    }

    public List<Thread> getThreads() {
        return threads;
    }
}
