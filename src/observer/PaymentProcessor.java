package observer;

import observer.dto.INDPayment;
import observer.dto.Payment;
import observer.publisher.PaymentProcessorPublisher;

public class PaymentProcessor {
    private final PaymentProcessorPublisher paymentProcessorPublisher;

    public PaymentProcessor(){
        paymentProcessorPublisher = new PaymentProcessorPublisher();
    }

    public void process(String accountNumber, String financialInstitutionIdentifier, String amount) {
        Payment payment = new INDPayment(accountNumber, financialInstitutionIdentifier);
        payment.setAmount(amount);
        System.out.println("Payment Processing Complete. Notifying Sanctions and Funds Control Processor");
        paymentProcessorPublisher.notifySubscriber(payment);
    }
}
