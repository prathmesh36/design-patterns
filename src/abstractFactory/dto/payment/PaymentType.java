package abstractFactory.dto.payment;

public abstract class PaymentType {

    int sla;
    int noOfCyclesInADay;

    abstract public void setSla();

    @Override
    public String toString() {
        return "PaymentType{" +
                "sla=" + sla +
                ", noOfCyclesInADay=" + noOfCyclesInADay +
                '}';
    }
}
