package strategy;

import org.json.JSONObject;
import strategy.dto.Payment;

public class PaymentDisplayStrategyJSON implements PaymentDisplayStrategy{
    @Override
    public String display(Payment payment) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("accountNumber", payment.getAccountNumber());
        jsonObject.put("financialInstitutionIdentifier", payment.getFinancialInstitutionIdentifier());
        jsonObject.put("financialInstitutionName", payment.getFinancialInstitutionName());
        jsonObject.put("amount", payment.getAmount());
        return jsonObject.toString();
    }
}
