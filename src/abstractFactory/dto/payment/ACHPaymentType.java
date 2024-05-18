package abstractFactory.dto.payment;

public class ACHPaymentType extends PaymentType{

    public ACHPaymentType(int count) {
        this.setNoOfCyclesInADay(count);
        this.setSla();
    }

    @Override
    public void setSla() {
        this.setSla((24 * 60 * 60)/this.getNoOfCyclesInADay());;
    }
}
