package proxy;

public class PaymentPublisherProxy implements PaymentPublisher{
    private PaymentPublisher paymentPublisher;

    public PaymentPublisherProxy(PaymentPublisher paymentPublisher) {
        this.paymentPublisher = paymentPublisher;
    }

    @Override
    public Boolean publishPayment(String payment) {
        payment = EncoderService.encode(payment);
        payment = CompressorService.compress(payment, 6);
        paymentPublisher.publishPayment(payment);
        return null;
    }
}
