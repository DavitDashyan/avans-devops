package devops;

public class Developer implements Persoon {
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Writing and testing code.");
    }
}
