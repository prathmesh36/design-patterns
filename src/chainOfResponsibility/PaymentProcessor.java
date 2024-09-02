package chainOfResponsibility;


import chainOfResponsibility.dto.INDPayment;
import chainOfResponsibility.dto.Payment;
import chainOfResponsibility.executors.DisplayStepExecutor;
import chainOfResponsibility.executors.EnrichmentStepExecutor;
import chainOfResponsibility.executors.StepExecutor;
import chainOfResponsibility.executors.ValidationStepExecutor;

public class PaymentProcessor {

    public void processPayment(String accountNumber, String financialInstitutionIdentifier, String amount) {
        Payment payment = new INDPayment(accountNumber, financialInstitutionIdentifier);
        payment.setAmount(amount);
        StepExecutor startExecutor = setExecutorChain();
        try {
            startExecutor.execute(payment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private StepExecutor setExecutorChain(){
        StepExecutor validationStepExecutor = new ValidationStepExecutor();
        StepExecutor enrichmentStepExecutor = new EnrichmentStepExecutor();
        StepExecutor displayStepExecutor = new DisplayStepExecutor();

        validationStepExecutor.setNextStep(enrichmentStepExecutor);
        enrichmentStepExecutor.setNextStep(displayStepExecutor);

        return validationStepExecutor;
    }
}
