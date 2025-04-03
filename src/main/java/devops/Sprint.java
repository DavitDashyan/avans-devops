package devops;

import java.util.Date;
import java.util.List;

import devops.generateReport.*;
import devops.sprintState.CreatedState;

public abstract class Sprint {
    protected int id;
    protected String name;
    protected Date startDatum;
    protected Date endDatum;
    protected SprintBacklog sprintBacklog;
    protected Person scrumMaster;
    protected Person productOwners;
    protected Person leadDeveloper;
    protected List<Person> developers;
    protected List<Person> testers;
    protected SprintState state = new CreatedState();

    public void setState(SprintState state) {
        this.state = state;
    }

    public void startSprint() {
        state.startSprint(this);
    }

    public void finishSprint() {
        state.finishSprint(this);
    }

    public void cancelSprint() {
        state.cancelSprint(this);
    }

    public void lockSprint() {
        state.lockSprint(this);
    }

    public void closeSprint() {
        state.closeSprint(this);
    }

    public void startReview() {
        state.startReview(this);
    }

    public void startRelease() {
        state.startRelease(this);
    }

    public String getStatus() {
        if (state != null) {
            return state.getStatus();
        }
        return "Unknown";
    }

    public Report generateReport(String reportType, String format) {
        ISprintReportFactory factory;

        switch (reportType.toLowerCase()) {
            case "burndownchart":
                factory = new BurndownChartReportFactory();
                break;
            case "effortpoints":
                factory = new EffortPointsFactory();
                break;
            case "teamsamenstelling":
                factory = new TeamsamenstellingReportFactory();
                break;
            default:
                throw new IllegalArgumentException("Invalid report type: " + reportType);
        }

        factory.addHeader();
        factory.addFooter();

        if (format.equalsIgnoreCase("pdf")) {
            IPDF pdfReport = factory.createPDF();
            pdfReport.savePDF();
            return new Report("Generated " + reportType + " report in PDF format.");
        } else if (format.equalsIgnoreCase("png")) {
            IPNG pngReport = factory.createPNG();
            pngReport.savePNG();
            return new Report("Generated " + reportType + " report in PNG format.");
        } else {
            throw new IllegalArgumentException("Invalid format: " + format);
        }
    }

    public void startPipeline(Pipeline pipeline) {
        if (!state.getStatus().equals("Finished")) {
            throw new IllegalStateException("Pipeline can only be started after the sprint is finished.");
        }
        System.out.println("Starting pipeline...");
        boolean success = pipeline.startPipeline();
        if (success) {
            System.out.println("Pipeline executed successfully. Sprint released.");
            closeSprint();
        } else {
            System.out.println("Pipeline execution failed. Notifying Scrum Master and Product Owner...");
            INotificationService emailService = new EmailNotificationService();
            NotificationManager notificationManager = new NotificationManager(emailService);
            notificationManager.update();
        }
    }
}
