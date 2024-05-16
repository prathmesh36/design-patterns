package decorator.dto;

public class PaymentGetterDecorator implements PaymentGetter{

    private PaymentGetter paymentGetter;

    public PaymentGetterDecorator(PaymentGetter paymentGetter){
        this.paymentGetter = paymentGetter;
    }

    @Override
    public String getPayment(String paymentMessage) {
        return paymentGetter.getPayment(paymentMessage);
    }
}
