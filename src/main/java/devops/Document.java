package devops;

import java.util.Date;

public class Document {
    private int id;
    private String title;
    private String content;
    private String fileType;
    private Date uploadDate;

    public Document(int id, String title, String content, String fileType, Date uploadDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fileType = fileType;
        this.uploadDate = uploadDate;
    }

    public void getDetails() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("File Type: " + fileType);
        System.out.println("Upload Date: " + uploadDate);
    }
}
