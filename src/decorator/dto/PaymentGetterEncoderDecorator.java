package decorator.dto;

import java.util.Base64;

public class PaymentGetterEncoderDecorator extends PaymentGetterDecorator{
    public PaymentGetterEncoderDecorator(PaymentGetter paymentGetter) {
        super(paymentGetter);
    }

    @Override
    public String getPayment(String paymentMessage) {
        return super.getPayment(encode(paymentMessage));
    }

    private String encode(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }
}
