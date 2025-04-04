package devops;

public class ReviewSprint extends Sprint {
    private SprintState state;
    private Document reviewDocument;

    public void endSprintReview() {
        System.out.println("Sprint review is beëindigd!");
    }

    public void uploadReview(Document document) {
        this.reviewDocument = document;
    }
}
