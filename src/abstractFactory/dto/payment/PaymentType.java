package abstractFactory.dto.payment;

public abstract class PaymentType {

    private int sla;
    private int noOfCyclesInADay;

    abstract public void setSla();

    public int getSla() {
        return sla;
    }

    public void setSla(int sla) {
        this.sla = sla;
    }

    public int getNoOfCyclesInADay() {
        return noOfCyclesInADay;
    }

    public void setNoOfCyclesInADay(int noOfCyclesInADay) {
        this.noOfCyclesInADay = noOfCyclesInADay;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "sla=" + sla +
                ", noOfCyclesInADay=" + noOfCyclesInADay +
                '}';
    }
}
