package devops;

public class LeadDeveloper implements Persoon {
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Leading the development team.");
    }

    public void statusPutReadyForTesting() {
        System.out.println("Status set to Ready for Testing.");
    }

    public void statusPutDone() {
        System.out.println("Status set to Done.");
    }
}
