package observer.publisher;

import observer.dto.Payment;
import observer.subscriber.Subscriber;

public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscriber(Payment payment);
}
