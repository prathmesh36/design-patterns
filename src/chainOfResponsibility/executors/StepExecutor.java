package chainOfResponsibility.executors;

import chainOfResponsibility.dto.Payment;

public interface StepExecutor {
    void execute(Payment payment) throws Exception;
    void setNextStep(StepExecutor stepExecutor);
}
