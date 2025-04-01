package devops.generateReport;

public class EffortPointsFactory implements ISprintReportFactory {
    @Override
    public void addHeader() {
        System.out.println("Adding header to Effort Points Report.");
    }

    @Override
    public void addFooter() {
        System.out.println("Adding footer to Effort Points Report.");
    }

    @Override
    public IPNG createPNG() {
        return new EffortPointsPNG();
    }

    @Override
    public IPDF createPDF() {
        return new EffortPointsPDF();
    }
}
