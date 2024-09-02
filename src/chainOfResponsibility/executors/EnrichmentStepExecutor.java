package chainOfResponsibility.executors;

import chainOfResponsibility.dto.Payment;

public class EnrichmentStepExecutor implements StepExecutor {
    private StepExecutor nextStepExecutor;

    @Override
    public void execute(Payment payment) throws Exception {
        System.out.println("Enrichment Step Executor Started");
        payment.setBankNameFromFinancialInstitutionIdentifier();
        nextStepExecutor.execute(payment);
    }

    @Override
    public void setNextStep(StepExecutor stepExecutor) {
        this.nextStepExecutor = stepExecutor;
    }
}
