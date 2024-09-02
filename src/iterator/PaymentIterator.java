package iterator;

import iterator.dto.Payment;
import java.util.*;

public class PaymentIterator implements Iterator<Payment>{
    private int currentIndex = 0;
    private List<Payment> payments;

    public PaymentIterator(List<Payment> payments){
        this.payments = payments;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < payments.size();
    }

    @Override
    public Payment next() throws Exception {
        if (!hasNext()) {
            throw new Exception("No Such Element");
        }
        return payments.get(currentIndex++);
    }
}
