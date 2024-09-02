package iterator;

import iterator.dto.INDPayment;
import iterator.dto.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessor {
    private AggregatePaymentProcessor aggregatePaymentProcessor;

    public void processPayment(){
        Payment payment1 = new INDPayment("3378924521", "SBIN1234");
        payment1.setAmount("150.00");
        Payment payment2 = new INDPayment("3378924521", "SBIN1234");
        payment2.setAmount("150.00");
        Payment payment3 = new INDPayment("3378924521", "SBIN1234");
        payment3.setAmount("150.00");

        List<Payment> payments = new ArrayList<>();
        payments.add(payment1);
        payments.add(payment2);
        payments.add(payment3);

        aggregatePaymentProcessor = new AggregatePaymentProcessor();
        aggregatePaymentProcessor.createIterator(payments);
        try {
            double totalAmount = aggregatePaymentProcessor.aggregatePaymentAmount();
            System.out.println("Total Aggregated Amount is " + totalAmount);
        } catch (Exception e) {
            System.out.println("Error Aggregating Payments: " + e.getMessage());
        }
    }
}
