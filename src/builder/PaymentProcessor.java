package builder;


import builder.dto.payment.Payment;


public class PaymentProcessor {
    private Payment payment;

    public PaymentProcessor(String accountNumber, String financialInstitutionIdentifier, String amount, String countryCode){
        try {
            payment = new Payment.Builder(accountNumber).amount(amount).countryCode(countryCode).financialInstitutionIdentifier(financialInstitutionIdentifier).build();
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPayment(){
        System.out.println(this.payment.toString());
    }
}
