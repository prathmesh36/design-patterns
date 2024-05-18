package composite;

import composite.dto.CompositeTransaction;
import composite.dto.TransactionImpl;

import java.util.List;

public class LedgerProcessor {
    private CompositeTransaction compositeTransaction;

    public LedgerProcessor(String referenceId, List<TransactionImpl> transactions){
        this.compositeTransaction = new CompositeTransaction(referenceId, transactions);
    }

    public void getBalance(){
        System.out.println("Transaction Batch Name: " + compositeTransaction.getReferenceId() + " Transaction Balance: " + compositeTransaction.getTotal());
    }



}
