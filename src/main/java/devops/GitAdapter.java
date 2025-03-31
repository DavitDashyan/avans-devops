package devops;

public class GitAdapter implements IVersionControl {
    private final GitService gitService;

    public GitAdapter(GitService gitService) {
        this.gitService = gitService;
    }

    @Override
    public void commit(String message, BacklogItem item) {
        gitService.gitCommit(message + " (Backlog Item ID: " );
    }

    @Override
    public void push() {
        gitService.gitPush();
    }

    @Override
    public void pull() {
        gitService.gitPull();
    }

    @Override
    public void createBranch(String name) {
        gitService.gitCreateBranch(name);
    }

    @Override
    public void merge(String fromBranch, String toBranch) {
        gitService.gitMerge(fromBranch, toBranch);
    }
}
