package chainOfResponsibility.executors;

import chainOfResponsibility.dto.Payment;

public class ValidationStepExecutor implements StepExecutor {
    private StepExecutor nextStepExecutor;

    @Override
    public void execute(Payment payment) throws Exception {
        System.out.println("Validation Step Executor Started");
        if (payment.getAccountNumber().length() != 10){
            throw new Exception("Validation Error: accountNumber of invalid length");
        }
        if (payment.getFinancialInstitutionIdentifier().length() != 8){
            throw new Exception("Validation Error: financialInstitutionIdentifier of invalid length");
        }
        if (!payment.getFinancialInstitutionIdentifier().substring(0,4).matches("[a-zA-Z]+")){
            throw new Exception("Validation Error: financialInstitutionIdentifier of invalid format");
        }
        if (!payment.getFinancialInstitutionIdentifier().substring(4,8).matches("[0-9]+")){
            throw new Exception("Validation Error: financialInstitutionIdentifier of invalid format");
        }
        nextStepExecutor.execute(payment);
    }

    @Override
    public void setNextStep(StepExecutor stepExecutor) {
        this.nextStepExecutor = stepExecutor;
    }
}
