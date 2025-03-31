package devops;

public class GitService {
    public void gitCommit(String message) {
        System.out.println("Git commit: " + message);
    }

    public void gitPush() {
        System.out.println("Git push executed.");
    }

    public void gitPull() {
        System.out.println("Git pull executed.");
    }

    public void gitCreateBranch(String name) {
        System.out.println("Git branch created: " + name);
    }

    public void gitMerge(String fromBranch, String toBranch) {
        System.out.println("Git merged branch " + fromBranch + " into " + toBranch);
    }
}
