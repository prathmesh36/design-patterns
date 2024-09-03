package observer;

import observer.dto.INDPayment;
import observer.dto.Payment;
import observer.publisher.PaymentProcessorPublisher;

public class SanctionsProcessor {

    public void process(Payment payment) {
        System.out.println("Perform Sanctions Processing");
    }
}
