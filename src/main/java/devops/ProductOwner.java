package devops;

public class ProductOwner implements Person {
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Managing the product backlog.");
    }
}
