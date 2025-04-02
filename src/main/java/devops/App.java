package devops;

import devops.backlogItemState.ToDoState;
import devops.backlogItemState.TestedState;
import devops.backlogItemState.ReadyForTestingState;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        // Create a project
        IVersionControl versionControl = new GitAdapter(new GitService());
        Project project = new Project(1, "DevOps Project", "A project for DevOps practices", new Date(), new Date(), versionControl);

        System.out.println("Project created:");
        project.getProjectDetails();

        // Create a backlog item and add it to the project backlog
        BacklogItem backlogItem = new BacklogItem(1, "Implement Login Feature", "Develop the login functionality for the application.", 1);
        project.getProjectBacklog().addBacklogItem(backlogItem);

        System.out.println("\nBacklog item added to project backlog:");
        backlogItem.getDetails();

        // Create a sprint and its sprint backlog
        Sprint sprint = project.createSprint("review", "Sprint 1", "First sprint for review", new Date(), new Date());
        SprintBacklog sprintBacklog = new SprintBacklog(sprint);

        System.out.println("\nSprint created:");
        System.out.println("Sprint Name: " + sprint.name);
        System.out.println("Sprint Start Date: " + sprint.startDatum);
        System.out.println("Sprint End Date: " + sprint.endDatum);

        // Assign a developer to the backlog item at the sprint level
        Developer developer = new Developer();
        sprintBacklog.addBacklogItem(backlogItem, developer);

        System.out.println("\nBacklog item added to sprint backlog and assigned to developer:");
        sprintBacklog.getSprintBacklog();

        // Start the sprint
        sprint.startSprint();
        System.out.println("\nSprint started. Current status: " + sprint.getStatus());

        // Simulate backlog item transitions
        System.out.println("\nTransitioning backlog item states:");
        backlogItem.moveToNextState(); // To Doing
        System.out.println("Backlog Item State: Doing");

        backlogItem.moveToNextState(); // To ReadyForTesting
        System.out.println("Backlog Item State: ReadyForTesting");

        // Notify testers
        Tester tester = new Tester();
        tester.statePutToDo();

        // Simulate tester finding an issue and moving the item back to ToDo
        backlogItem.moveToFirstState(); // Back to ToDo
        System.out.println("Backlog Item State: ToDo");

        // Simulate testing and moving to Tested
        backlogItem.moveToNextState(); // To Doing
        backlogItem.moveToNextState(); // To ReadyForTesting
        backlogItem.moveToNextState(); // To Testing
        backlogItem.moveToNextState(); // To Tested
        System.out.println("Backlog Item State: Tested");

        // Lead developer checks definition of done
        LeadDeveloper leadDeveloper = new LeadDeveloper();
        leadDeveloper.statusPutDone();

        // Simulate moving to Done
        backlogItem.moveToNextState(); // To Done
        System.out.println("Backlog Item State: Done");

        // End the sprint
        sprint.finishSprint();
        System.out.println("\nSprint finished. Current status: " + sprint.getStatus());

        // Handle review or release process
        if (sprint instanceof ReviewSprint) {
            System.out.println("\nStarting review process...");
            sprint.startReview();
            System.out.println("Sprint moved to review phase. Current status: " + sprint.getStatus());

            // Upload review document
            Document reviewDocument = new Document(1, "Sprint Review Summary", "Summary of the sprint review.", "pdf", new Date());
            ((ReviewSprint) sprint).uploadReview(reviewDocument);
            System.out.println("Review document uploaded.");

            // Close the sprint after review
            sprint.closeSprint();
            System.out.println("Sprint closed. Current status: " + sprint.getStatus());
        } else if (sprint instanceof DeploymentSprint) {
            System.out.println("\nStarting release process...");
            sprint.startRelease();
            System.out.println("Sprint moved to release phase. Current status: " + sprint.getStatus());

            // Simulate pipeline execution
            Pipeline pipeline = new Pipeline();
            sprint.startPipeline(pipeline);

            boolean pipelineSuccess = pipeline.startPipeline();

            if (pipelineSuccess) {
                System.out.println("Pipeline executed successfully. Sprint released.");
                sprint.closeSprint();
                System.out.println("Sprint closed. Current status: " + sprint.getStatus());
            } else {
                System.out.println("Pipeline execution failed. Notifying Scrum Master and Product Owner...");
                INotificationService emailService = new EmailNotificationService();
                NotificationManager notificationManager = new NotificationManager(emailService);
                notificationManager.update();
            }
        }

        // Handle discussions related to backlog items
        System.out.println("\nHandling discussions for backlog items...");
        Discussion discussion = new Discussion();
        Thread thread = new Thread(backlogItem); // Pass the backlogItem to the thread constructor
        thread.lockIfBacklogItemDone();
        backlogItem.moveToFirstState(); // Back to ToDo
        thread.unlockIfBacklogItemNotDone();

        Message message = new Message(1, "This is a discussion message.", developer, new Date(), thread);

        thread.addMessage(message);
        discussion.addThread(thread);
        System.out.println("Discussion and messages added successfully.");
    }
}
