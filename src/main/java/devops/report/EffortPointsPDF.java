package devops.report;

public class EffortPointsPDF implements IPDF {
    @Override
    public void savePDF() {
        System.out.println("Saving Effort Points Report as PDF.");
    }
}
