package devops.pipelineSteps;

import devops.PipelineStep;
import devops.Sprint;

public class DeploymentStep implements PipelineStep {
    private String deployTarget;
    private PipelineStep nextStep;
    private boolean succeeded;
    private Sprint sprint;

    @Override
    public boolean execute() {
        executeStep();
        return succeeded;
    }

    private void executeStep() {
        // ...implementation...
        succeeded = true; // Assume success for now
    }

    public void setSprintToClosed(Sprint sprint) {
        this.sprint = sprint;
        sprint.closeSprint();
    }

    @Override
    public void setNextStep(PipelineStep nextStep) {
        this.nextStep = nextStep;
    }

    @Override
    public PipelineStep getNextStep() {
        return nextStep;
    }

    @Override
    public boolean hasSucceeded() {
        return succeeded;
    }
}
