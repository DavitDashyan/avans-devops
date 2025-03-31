package devops;

import java.util.Date;

public class Document {
    private int id;
    private String titel;
    private String content;
    private String fileType;
    private Date uploadDate;

    public void getDetails() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + titel);
        System.out.println("Content: " + content);
        System.out.println("File Type: " + fileType);
        System.out.println("Upload Date: " + uploadDate);
    }
}
