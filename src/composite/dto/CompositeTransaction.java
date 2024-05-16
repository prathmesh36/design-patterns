package composite.dto;

import java.util.List;

public class CompositeTransaction extends TransactionImpl{

    String referenceId;
    List<TransactionImpl> transactions;

    public CompositeTransaction(String referenceId, List<TransactionImpl> transactions) {
        super(0);
        this.referenceId = referenceId;
        this.transactions = transactions;
    }

    @Override
    public double getTotal() {
        double total = 0;
        for(TransactionImpl transaction: transactions){
            total += transaction.getTotal();
        }
        return total;
    }

    public String getReferenceId(){
        return referenceId;
    }
}
