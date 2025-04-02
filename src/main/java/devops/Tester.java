package devops;

public class Tester implements Person {
    @Override
    public void performRoleSpecificTask() {
        System.out.println("Testing the application.");
    }

    public void statePutToDo() {
        System.out.println("State set to To Do.");
    }

    public void statePutTested() {
        System.out.println("State set to Tested.");
    }
}
