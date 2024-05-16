package composite.dto;

public class DebitTransaction extends TransactionImpl{
    public DebitTransaction(double amount) {
        super(amount);
    }

    @Override
    public double getTotal(){
        return -super.amount;
    }
}
