package observer.subscriber;

import observer.FundsControlProcessor;
import observer.dto.Payment;

public class FundsControlSubscriber implements Subscriber {
    private final FundsControlProcessor fundsControlProcessor;

    public FundsControlSubscriber(){
        fundsControlProcessor = new FundsControlProcessor();
    }

    @Override
    public void update(Payment payment) {
        fundsControlProcessor.process(payment);
    }
}
