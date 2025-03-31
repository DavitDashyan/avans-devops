package devops;

public interface PipelineStep {
    boolean execute(); // Removed PipelineContext
    void setNextStep(PipelineStep nextStep);
    PipelineStep getNextStep();
    boolean hasSucceeded();
}
