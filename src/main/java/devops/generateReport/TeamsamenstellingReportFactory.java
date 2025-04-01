package devops.generateReport;

public class TeamsamenstellingReportFactory implements ISprintReportFactory {
    @Override
    public void addHeader() {
        System.out.println("Adding header to Teamsamenstelling Report.");
    }

    @Override
    public void addFooter() {
        System.out.println("Adding footer to Teamsamenstelling Report.");
    }

    @Override
    public IPNG createPNG() {
        return new TeamsamenstellingReportPNG();
    }

    @Override
    public IPDF createPDF() {
        return new TeamsamenstellingReportPDF();
    }
}
