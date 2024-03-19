package abstractFactory;

import abstractFactory.dto.payment.Payment;
import factory.PaymentFactory;

public class PaymentProcessor {
    Payment payment;

    public PaymentProcessor(String accountNumber, String financialInstitutionIdentifier, String amount, String countryCode, boolean isRTP){
        try {
            this.payment = switch (countryCode) {
                case "IND" -> INDPaymentFactory.generatePayment(accountNumber, financialInstitutionIdentifier, amount, isRTP);
                case "US" -> USPaymentFactory.generatePayment(accountNumber, financialInstitutionIdentifier, amount, isRTP);
                default -> throw new Exception();
            };
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPayment(){
        System.out.println(this.payment.toString());
    }
}
