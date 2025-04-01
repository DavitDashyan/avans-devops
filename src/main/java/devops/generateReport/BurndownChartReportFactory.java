package devops.generateReport;

public class BurndownChartReportFactory implements ISprintReportFactory {
    @Override
    public void addHeader() {
        System.out.println("Adding header to Burndown Chart Report.");
    }

    @Override
    public void addFooter() {
        System.out.println("Adding footer to Burndown Chart Report.");
    }

    @Override
    public IPNG createPNG() {
        return new BurndownChartReportPNG();
    }

    @Override
    public IPDF createPDF() {
        return new BurndownChartReportPDF();
    }
}
