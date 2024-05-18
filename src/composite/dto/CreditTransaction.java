package composite.dto;

public class CreditTransaction extends TransactionImpl{
    public CreditTransaction(double amount) {
        super(amount);
    }

    @Override
    public double getTotal(){
        return super.getAmount();
    }
}
