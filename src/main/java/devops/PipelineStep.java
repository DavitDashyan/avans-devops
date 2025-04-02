package devops;

public interface PipelineStep {
    boolean execute();
    void setNextStep(PipelineStep nextStep);
    PipelineStep getNextStep();
    boolean hasSucceeded();
}
