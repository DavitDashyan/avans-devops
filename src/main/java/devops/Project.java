package devops;

import java.util.Date;
import java.util.List;

public class Project {
    private int id;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private ProjectBacklog projectBacklog;
    private List<Sprint> sprints;
    private List<Persoon> team;
    private IVersionControl versionControl;

    public Project(IVersionControl versionControl) {
        this.versionControl = versionControl;
    }

    public void addTeamMember(Persoon teamMember) {
        team.add(teamMember);
    }

    public void removeTeamMember(Persoon teamMember) {
        team.remove(teamMember);
    }

    public Sprint createSprint(String type, String title, String description, Date startDate, Date endDate) {
        Sprint sprint;

        // Determine the type of sprint to create
        if (type.equalsIgnoreCase("review")) {
            sprint = new ReviewSprint();
        } else if (type.equalsIgnoreCase("deployment")) {
            sprint = new DeploymentSprint();
        } else {
            throw new IllegalArgumentException("Invalid sprint type: " + type);
        }

        // Set common sprint properties
        sprint.name = title;
        sprint.startDatum = startDate;
        sprint.endDatum = endDate;

        // Add the sprint to the project
        sprints.add(sprint);
        return sprint;
    }

    public void commitBacklogItem(String message, BacklogItem item) {
        versionControl.commit(message, item);
    }

    public void pushChanges() {
        versionControl.push();
    }

    public void pullChanges() {
        versionControl.pull();
    }

    public void createBranch(String name) {
        versionControl.createBranch(name);
    }

    public void mergeBranches(String fromBranch, String toBranch) {
        versionControl.merge(fromBranch, toBranch);
    }

    public void getProjectDetails() {
        System.out.println("Project ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
    }
}
