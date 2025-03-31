package devops;

public class ReviewSprint extends Sprint {
    private SprintState state;
    private Document reviewDocument;

    public void endSprintReview() {
        // ...implementation...
    }

    public void uploadReview(Document document) {
        this.reviewDocument = document;
    }
}
