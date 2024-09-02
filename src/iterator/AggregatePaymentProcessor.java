package iterator;

import iterator.dto.Payment;

import java.util.List;

public class AggregatePaymentProcessor {
    Iterator<Payment> paymentIterator;

    public double aggregatePaymentAmount() throws Exception {
        double totalAmount = 0;
        while (paymentIterator.hasNext()) {
            totalAmount += Double.parseDouble(paymentIterator.next().getAmount());
        }
        return totalAmount;
    }

    public void createIterator(List<Payment> payments){
        this.paymentIterator = new PaymentIterator(payments);
    }
}
