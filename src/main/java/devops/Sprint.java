package devops;

import java.util.Date;
import java.util.List;

import devops.sprintState.CreateState;
import devops.report.*;

public abstract class Sprint {
    protected int id;
    protected String name;
    protected Date startDatum;
    protected Date endDatum;
    protected SprintBacklog sprintBacklog;
    protected Persoon scrumMaster;
    protected Persoon productOwners;
    protected Persoon leadDeveloper;
    protected List<Persoon> developers;
    protected List<Persoon> testers;
    protected SprintState state = new CreateState();

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

    public String getStatus() {
        return state.getStatus();
    }

    public Report generateReport(String reportType, String format) {
        ISprintReportFactory factory;

        // Determine the report factory based on the report type
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

        // Add header and footer to the report
        factory.addHeader();
        factory.addFooter();

        // Generate the report in the specified format
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
