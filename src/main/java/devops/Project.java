package devops;

import java.util.ArrayList;
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
    private List<Person> team;
    private IVersionControl versionControl;

    public Project(int id, String title, String description, Date startDate, Date endDate, IVersionControl versionControl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.versionControl = versionControl;
        this.projectBacklog = new ProjectBacklog(this);
        this.sprints = new ArrayList<>();
        this.team = new ArrayList<>();
    }

    public void addTeamMember(Person teamMember) {
        team.add(teamMember);
    }

    public void removeTeamMember(Person teamMember) {
        team.remove(teamMember);
    }

    public Sprint createSprint(String type, String title, String description, Date startDate, Date endDate) {
        Sprint sprint;

        if (type.equalsIgnoreCase("review")) {
            sprint = new ReviewSprint();
        } else if (type.equalsIgnoreCase("deployment")) {
            sprint = new DeploymentSprint();
        } else {
            throw new IllegalArgumentException("Invalid sprint type: " + type);
        }

        sprint.name = title;
        sprint.startDatum = startDate;
        sprint.endDatum = endDate;

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

    public ProjectBacklog getProjectBacklog() {
        return projectBacklog;
    }
}
