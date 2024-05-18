package decorator;

import decorator.dto.*;

public class PaymentProcessor {
    private String paymentMessage;
    private String paymentMessageCompressed;
    private String paymentMessageEncoded;
    private String paymentMessageCompressedEncoded;
    private String paymentMessageEncodedCompressed;

    public PaymentProcessor(String accountNumber, String financialInstitutionIdentifier, String financialInstitutionName, String amount){
        try {
            Payment payment = new Payment(accountNumber, financialInstitutionIdentifier, financialInstitutionName, amount);
            this.paymentMessage = payment.toString();

            PaymentGetter paymentGetterCompressedEncoded = new PaymentGetterCompressorDecorator(new PaymentGetterEncoderDecorator(new SimplePaymentGetter()));
            this.paymentMessageCompressedEncoded = paymentGetterCompressedEncoded.getPayment(this.paymentMessage);

            PaymentGetter paymentGetterEncodedCompressed = new PaymentGetterEncoderDecorator(new PaymentGetterCompressorDecorator(new SimplePaymentGetter()));
            this.paymentMessageEncodedCompressed = paymentGetterEncodedCompressed.getPayment(this.paymentMessage);

            PaymentGetter paymentGetterEncoded = new PaymentGetterEncoderDecorator(new SimplePaymentGetter());
            this.paymentMessageEncoded = paymentGetterEncoded.getPayment(this.paymentMessage);

            PaymentGetter paymentGetterCompressed = new PaymentGetterCompressorDecorator(new SimplePaymentGetter());
            this.paymentMessageCompressed = paymentGetterCompressed.getPayment(this.paymentMessage);

        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPayment(){
        System.out.println("Original Message: " + this.paymentMessage);
        System.out.println("CompressedEncoded Message: " + this.paymentMessageCompressedEncoded);
        System.out.println("EncodedCompressed Message: " + this.paymentMessageEncodedCompressed);
        System.out.println("Compressed Message: " + this.paymentMessageCompressed);
        System.out.println("Encoded Message: " + this.paymentMessageEncoded);
    }
}
