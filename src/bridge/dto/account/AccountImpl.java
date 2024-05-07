package bridge.dto.account;

import java.util.List;
import java.util.Map;

public class AccountImpl implements Account{
    private Double balance = 100.00;
    private boolean status = false;
    private String accountNo;
    private String bankIdentificationCode;

    @Override
    public Double getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(Double balance) {
        this.balance = balance;
    }


    @Override
    public boolean isActive() {
        return this.status;
    }

    @Override
    public void activate() {
        this.status = true;
    }

    @Override
    public void deactivate() {
        this.status = false;
    }

    @Override
    public void getReport() {
        System.out.println("Balance: " + balance);
        System.out.println("Status isActive: " + this.isActive());
        System.out.println("Account No.: " + this.getAccountNo());
    }

    @Override
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String getAccountNo() {
        return this.accountNo;
    }


    @Override
    public String getBankIdentificationCode() {
        return this.bankIdentificationCode;
    }

    @Override
    public void setBankIdentificationCode(String bankIdentificationCode) {
        this.bankIdentificationCode = bankIdentificationCode;
    }


    // Age not relevant
    @Override
    public int getAge() {
        return 18;
    }

    @Override
    public void setAge(int age) {

    }

    // term deposit not relevant
    @Override
    public void setTermDeposits(Map<String, List<Double>> termDeposits) {
        System.out.println("Operation Not Supported: Please make term deposits via tour savings accnount");
    }

    @Override
    public Map<String, List<Double>> getTermDeposits() {
        return null;
    }


}
