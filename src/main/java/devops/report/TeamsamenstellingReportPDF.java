package devops.report;

public class TeamsamenstellingReportPDF implements IPDF {
    @Override
    public void savePDF() {
        System.out.println("Saving Teamsamenstelling Report as PDF.");
    }
}
