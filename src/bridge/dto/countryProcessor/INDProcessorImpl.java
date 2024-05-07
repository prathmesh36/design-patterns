package bridge.dto.countryProcessor;

import bridge.dto.account.Account;

public class INDProcessorImpl extends CommonProcessorImpl{
    public INDProcessorImpl(Account account) {
        super(account);
    }

    public void createFixedDeposit(Double amount, Double term, Double roi){
        createTermDeposit(amount, term, roi);
    }

    public void showIFSCCode(){
        System.out.print("IFSC Code: ");
        showBankIdentificationCode();
    }

    @Override
    public void showAccountDetails(){
        super.showAccountDetails();
        if(account.getTermDeposits() != null) {
            System.out.println("Fixed Deposits: " + account.getTermDeposits().toString());
        }
        System.out.println("---------------------------------------");
    }

}
