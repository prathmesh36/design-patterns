package bridge.dto.account;

import java.util.List;
import java.util.Map;

public interface Account {
    Double getBalance();
    void setBalance(Double balance);

    int getAge();
    void setAge(int age);

    boolean isActive();
    void activate();
    void deactivate();

    void getReport();

    void setAccountNo(String accountNo);
    String getAccountNo();

    String getBankIdentificationCode();
    void setBankIdentificationCode(String bankIdentificationCode);

    void setTermDeposits(Map<String, List<Double>> termDeposits);
    Map<String, List<Double>> getTermDeposits();

}
