package observer.publisher;

import observer.dto.Payment;
import observer.subscriber.FundsControlSubscriber;
import observer.subscriber.SanctionsSubscriber;
import observer.subscriber.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class PaymentProcessorPublisher implements Publisher{
    private final List<Subscriber> subscribers = new ArrayList<>();

    public PaymentProcessorPublisher(){
        addSubscriber(new SanctionsSubscriber());
        addSubscriber(new FundsControlSubscriber());
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber(Payment payment) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(payment);
        }
    }
}
