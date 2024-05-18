package abstractFactory.dto.payment;

public class RTPPaymentType extends PaymentType{

    public RTPPaymentType(int count) {
        this.setNoOfCyclesInADay(count);
        this.setSla();
    }

    @Override
    public void setSla() {
        this.setSla(15);
    }
}
