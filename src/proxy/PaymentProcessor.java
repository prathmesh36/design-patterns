package proxy;

import proxy.dto.Payment;

public class PaymentProcessor {
    private Payment payment;

    public PaymentProcessor(Payment payment) {
        this.payment = payment;
    }

    public void publishPayment(){
        PaymentPublisher paymentPublisher = new PaymentPublisherImpl();
        PaymentPublisher paymentPublisherProxy = new PaymentPublisherProxy(paymentPublisher);
        paymentPublisherProxy.publishPayment(payment.toString());
    }
}
