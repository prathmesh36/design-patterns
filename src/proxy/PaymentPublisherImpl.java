package proxy;


public class PaymentPublisherImpl implements PaymentPublisher{

    @Override
    public Boolean publishPayment(String payment) {
        System.out.println("Publishing Payment message: " + payment);
        return true;
    }
}
