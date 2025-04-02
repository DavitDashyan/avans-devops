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
        return state.getStatus();
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
}
