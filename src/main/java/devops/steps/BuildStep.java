package devops.steps;

import devops.PipelineStep;

public class BuildStep implements PipelineStep {
    private String buildTool;
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
