package prototype;


import prototype.dto.payment.Payment;

public class PaymentProcessor {
    Payment payment;

    public PaymentProcessor(String accountNumber, String amount, String countryCode){
        try {
            this.payment = new PaymentPrototypeRegistry().createPayment(countryCode);
            this.payment.setAmount(amount);
            this.payment.setAccountNumber(accountNumber);
            this.payment.setBankNameFromFinancialInstitutionIdentifier();
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPayment(){
        System.out.println(this.payment.toString());
    }
}
