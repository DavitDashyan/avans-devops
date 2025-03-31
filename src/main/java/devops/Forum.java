package devops;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Forum {
    private int id;
    private String title;
    private Date creationDate;
    private List<Discussion> threads = new ArrayList<>();

    public void addDiscussion(Discussion discussion) {
        threads.add(discussion);
    }

    public void removeDiscussion(Discussion discussion) {
        threads.remove(discussion);
    }

    public List<Discussion> getDiscussions() {
        return threads;
    }
}
