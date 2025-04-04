package devops;

import java.util.Date;

public class DeploymentSprint extends Sprint {
    private SprintState state;
    private Pipeline pipeline;
    private Date releaseDatum;

    public void resultsGoodEnough() {
        System.out.println("Resultaten zijn goed genoeg!");
    }

    public void startDeployment() {
        System.out.println("Deployment gestart!");
    }

    public void checkDeployment() {
        System.out.println("Deployment goed!");
    }
}
