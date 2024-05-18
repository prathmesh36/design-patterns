package bridge.service.countryProcessor;

import bridge.dto.account.Account;

public class USProcessorImpl extends CommonProcessorImpl{

    public USProcessorImpl(Account account) {
        super(account);
    }

    public void createCertificateOfDeposit(Double amount, Double term, Double roi){
        createTermDeposit(amount, term, roi);
    }

    public void showRoutingNo(){
        System.out.print("Routing No: ");
        showBankIdentificationCode();
    }

    @Override
    public boolean openAccount(String accountNo, String bankIdentificationCode, int age) {
        this.getAccount().setAge(age);
        if(this.getAccount().getAge() >= 18){
            this.getAccount().setAccountNo(accountNo);
            this.getAccount().setBankIdentificationCode(bankIdentificationCode);
            this.getAccount().activate();
            return true;
        }else{
            System.out.println("Operation cannot be performed: Age should be greater than 18 for a checking account");
            return false;
        }
    }

    @Override
    public void showAccountDetails(){
        super.showAccountDetails();
        if(getAccount().getTermDeposits() != null){
            System.out.println("Certificate of Deposits: " + getAccount().getTermDeposits().toString());
        }
        System.out.println("---------------------------------------");

    }
}
