package devops.steps;

import devops.PipelineStep;

public class PackageStep implements PipelineStep {
    private final String stepName = "Install Packages";
    private PipelineStep nextStep;
    private boolean succeeded;

    @Override
    public boolean execute() {
        executeStep();
        return succeeded;
    }

    private void executeStep() {
        // ...implementation...
        succeeded = true; // Assume success for now
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
