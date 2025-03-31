package devops;

import java.util.Date;

public class Message {
    private int id;
    private String text;
    private Persoon author;
    private Date date;
    private Thread thread;

    public Message(int id, String text, Persoon author, Date date, Thread thread) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.date = date;
        this.thread = thread;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Persoon getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public Thread getThread() {
        return thread;
    }
}
