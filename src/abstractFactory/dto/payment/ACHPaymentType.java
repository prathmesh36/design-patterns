package abstractFactory.dto.payment;

public class ACHPaymentType extends PaymentType{

    public ACHPaymentType(int count) {
        this.noOfCyclesInADay = count;
        this.setSla();
    }

    @Override
    public void setSla() {
        this.sla = (24 * 60 * 60)/this.noOfCyclesInADay;
    }
}
