package devops;

public class ProductOwner implements Persoon {
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Managing the product backlog.");
    }
}
