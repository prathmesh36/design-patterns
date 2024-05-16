package decorator.dto;

public class SimplePaymentGetter implements PaymentGetter {

    @Override
    public String getPayment(String paymentMessage) {
        return paymentMessage;
    }
}
