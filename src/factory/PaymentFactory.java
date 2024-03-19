package factory;

import factory.dto.payment.INDPayment;
import factory.dto.payment.Payment;
import factory.dto.payment.USPayment;

public class PaymentFactory {
    static Payment generatePayment(String accountNumber, String financialInstitutionIdentifier, String amount, String countryCode) throws Exception {
        Payment payment = switch (countryCode) {
            case "IND" -> new INDPayment(accountNumber, financialInstitutionIdentifier);
            case "US" -> new USPayment(accountNumber, financialInstitutionIdentifier);
            default -> throw new Exception();
        };
        payment.setAmount(amount);
        payment.setBankNameFromFinancialInstitutionIdentifier();

        return payment;
    }
}
