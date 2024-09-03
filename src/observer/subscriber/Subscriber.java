package observer.subscriber;


import observer.dto.Payment;

public interface Subscriber {
    void update(Payment payment);
}
