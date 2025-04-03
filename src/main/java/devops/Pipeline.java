package devops;

import java.util.List;

public class Pipeline {
    private int id;
    private String title;
    private List<PipelineStep> steps;
    private Sprint sprintToLock;

    public void setSprintToLock(Sprint sprint) {
        this.sprintToLock = sprint;
    }

    public void setSteps(List<PipelineStep> steps) {
        this.steps = steps;
    }

    public boolean startPipeline() {
        PipelineStep currentStep = steps.get(0);
        while (currentStep != null) {
            if (!currentStep.execute()) {
                return false;
            }
            currentStep = currentStep.getNextStep();
        }
        return true;
    }

    public boolean hasSucceeded() {
        return steps.stream().allMatch(PipelineStep::hasSucceeded);
    }
}
