package devops;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PipelineTest {
    private Pipeline pipeline;
    private PipelineStep step1;
    private PipelineStep step2;

    @BeforeEach
    void setUp() {
        step1 = mock(PipelineStep.class);
        step2 = mock(PipelineStep.class);
        when(step1.getNextStep()).thenReturn(step2);
        when(step2.getNextStep()).thenReturn(null);

        pipeline = new Pipeline();
        pipeline.setSteps(List.of(step1, step2));
    }

    @Test
    void testStartPipelineSuccess() {
        when(step1.execute()).thenReturn(true);
        when(step2.execute()).thenReturn(true);

        assertTrue(pipeline.startPipeline());
        verify(step1).execute();
        verify(step2).execute();
    }

    @Test
    void testStartPipelineFailureAtSecondStep() {
        when(step1.execute()).thenReturn(true);
        when(step2.execute()).thenReturn(false);

        assertFalse(pipeline.startPipeline());
        verify(step1).execute();
        verify(step2).execute();
    }

    @Test
    void testStartPipelineFailureAtFirstStep() {
        when(step1.execute()).thenReturn(false);

        assertFalse(pipeline.startPipeline());
        verify(step1).execute();
        verify(step2, never()).execute();
    }

    @Test
    void testHasSucceededWhenAllStepsSucceed() {
        when(step1.hasSucceeded()).thenReturn(true);
        when(step2.hasSucceeded()).thenReturn(true);

        assertTrue(pipeline.hasSucceeded());
    }

    @Test
    void testHasSucceededWhenOneStepFails() {
        when(step1.hasSucceeded()).thenReturn(true);
        when(step2.hasSucceeded()).thenReturn(false);

        assertFalse(pipeline.hasSucceeded());
    }
}
