package bridge.dto.countryProcessor;

public interface CommonProcessor {
    void debit(Double amount);
    void credit(Double amount);

    void closeAccount();
    void reopenAccount();
    boolean openAccount(String accountNo, String bankIdentificationCode, int age);

    void createTermDeposit(Double amount, Double term, Double roi);

    void showBankIdentificationCode();
    void showAccountDetails();
}
