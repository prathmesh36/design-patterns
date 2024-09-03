package observer.subscriber;

import observer.SanctionsProcessor;
import observer.dto.Payment;

public class SanctionsSubscriber implements Subscriber {
    private final SanctionsProcessor sanctionsProcessor;

    public SanctionsSubscriber(){
        sanctionsProcessor = new SanctionsProcessor();
    }

    @Override
    public void update(Payment payment) {
        sanctionsProcessor.process(payment);
    }
}
