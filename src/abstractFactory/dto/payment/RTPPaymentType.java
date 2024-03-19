package abstractFactory.dto.payment;

public class RTPPaymentType extends PaymentType{

    public RTPPaymentType(int count) {
        this.noOfCyclesInADay = count;
        this.setSla();
    }

    @Override
    public void setSla() {
        this.sla = 15;
    }
}
