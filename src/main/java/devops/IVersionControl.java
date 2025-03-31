package devops;

public interface IVersionControl {
    void commit(String message, BacklogItem item);
    void push();
    void pull();
    void createBranch(String name);
    void merge(String fromBranch, String toBranch);
}
