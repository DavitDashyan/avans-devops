package devops;

public class Report {
    private String content;

    public Report(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void display() {
        System.out.println("Report Content: " + content);
    }
}
