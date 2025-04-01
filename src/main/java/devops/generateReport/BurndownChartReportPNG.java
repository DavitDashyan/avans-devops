package devops.generateReport;

public class BurndownChartReportPNG implements IPNG {
    @Override
    public void savePNG() {
        System.out.println("Saving Burndown Chart Report as PNG.");
    }
}
