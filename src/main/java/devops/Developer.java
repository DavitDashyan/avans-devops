package devops;

public class Developer implements Person {
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Writing and testing code.");
    }
}
