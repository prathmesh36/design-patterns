package bridge;


import bridge.constant.Account;
import bridge.constant.Country;
import bridge.dto.account.CheckingAccount;
import bridge.dto.account.SavingAccount;
import bridge.service.countryProcessor.INDProcessorImpl;
import bridge.service.countryProcessor.USProcessorImpl;

public class AccountProcessor {

    public AccountProcessor(String accountNumber, String bankIdentificationCode, int age, Country country, Account accountType){
        System.out.println("------------------Account Processor Running-----------------");
        try {
            bridge.dto.account.Account account = null;
            if(accountType == Account.SAVINGS){
                account = new SavingAccount();
            }else if(accountType == Account.CHECKING){
                account = new CheckingAccount();
            }

            if(country == Country.US){
                USProcessorImpl usProcessor = new USProcessorImpl(account);
                if(usProcessor.openAccount(accountNumber, bankIdentificationCode, age)) {
                    usProcessor.credit(100.0);
                    usProcessor.showAccountDetails();
                    usProcessor.debit(50.00);
                    usProcessor.showAccountDetails();
                    usProcessor.showRoutingNo();
                    usProcessor.createCertificateOfDeposit(50.0, 1.0, 2.0);
                    usProcessor.showAccountDetails();
                    usProcessor.closeAccount();
                    usProcessor.showAccountDetails();
                    usProcessor.reopenAccount();
                    usProcessor.showAccountDetails();
                }
            }else{
                INDProcessorImpl indProcessor = new INDProcessorImpl(account);
                if(indProcessor.openAccount(accountNumber, bankIdentificationCode, age)) {
                    indProcessor.credit(100.0);
                    indProcessor.showAccountDetails();
                    indProcessor.debit(50.00);
                    indProcessor.showAccountDetails();
                    indProcessor.showIFSCCode();
                    indProcessor.createFixedDeposit(50.0, 1.0, 2.0);
                    indProcessor.showAccountDetails();
                    indProcessor.closeAccount();
                    indProcessor.showAccountDetails();
                    indProcessor.reopenAccount();
                    indProcessor.showAccountDetails();
                }
            }

        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

}
