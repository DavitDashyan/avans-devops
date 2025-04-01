package devops.generateReport;

public class BurndownChartReportPDF implements IPDF {
    @Override
    public void savePDF() {
        System.out.println("Saving Burndown Chart Report as PDF.");
    }
}
