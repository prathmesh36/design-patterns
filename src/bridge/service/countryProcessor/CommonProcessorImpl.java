package bridge.service.countryProcessor;

import bridge.dto.account.Account;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class CommonProcessorImpl implements CommonProcessor {
    Account account;

    public CommonProcessorImpl(Account account){
        this.account = account;
    }

    @Override
    public void debit(Double amount) {
        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public void credit(Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void closeAccount() {
        account.deactivate();
    }

    @Override
    public void reopenAccount() {
        account.activate();
    }

    @Override
    public boolean openAccount(String accountNo, String bankIdentificationCode, int age) {
        this.account.setAge(age);
        this.account.setAccountNo(accountNo);
        this.account.setBankIdentificationCode(bankIdentificationCode);
        this.account.activate();
        return true;
    }

    @Override
    public void createTermDeposit(Double amount, Double term, Double roi){
        this.account.setBalance(this.account.getBalance() - amount);
        this.account.setTermDeposits(Map.of(
                UUID.randomUUID().toString(), Arrays.asList(amount, term, roi)
        ));
    }

    @Override
    public void showBankIdentificationCode() {
        System.out.println(account.getBankIdentificationCode());
    }

    @Override
    public void showAccountDetails() {
        account.getReport();
    }
}
