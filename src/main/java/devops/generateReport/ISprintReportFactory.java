package devops.generateReport;

public interface ISprintReportFactory {
    void addHeader();
    void addFooter();
    IPNG createPNG();
    IPDF createPDF();
}
