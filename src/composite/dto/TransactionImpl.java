package composite.dto;

public abstract class TransactionImpl implements Transaction{
    double amount = 0;

    public TransactionImpl(double amount){
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract double getTotal();
}
