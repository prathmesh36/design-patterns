package chainOfResponsibility.executors;

import chainOfResponsibility.dto.Payment;
import org.json.JSONObject;

public class DisplayStepExecutor implements StepExecutor {
    private StepExecutor nextStepExecutor;

    @Override
    public void execute(Payment payment) throws Exception {
        System.out.println("Display Step Executor Started");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accountNumber", payment.getAccountNumber());
        jsonObject.put("financialInstitutionIdentifier", payment.getFinancialInstitutionIdentifier());
        jsonObject.put("financialInstitutionName", payment.getFinancialInstitutionName());
        jsonObject.put("amount", payment.getAmount());
        System.out.println(jsonObject);
    }

    @Override
    public void setNextStep(StepExecutor stepExecutor) {

    }
}
