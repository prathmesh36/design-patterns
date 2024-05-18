package factory;

import factory.dto.payment.Payment;

public class PaymentProcessor {
    private Payment payment;

    public PaymentProcessor(String accountNumber, String financialInstitutionIdentifier, String amount, String countryCode){
        try {
            this.payment = PaymentFactory.generatePayment(accountNumber, financialInstitutionIdentifier, amount, countryCode);
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPayment(){
        System.out.println(this.payment.toString());
    }
}
