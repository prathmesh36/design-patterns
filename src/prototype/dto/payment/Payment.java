package prototype.dto.payment;

abstract public class Payment implements Cloneable {
    String accountNumber;
    String financialInstitutionIdentifier;
    String financialInstitutionName;
    String amount;

    public abstract void setBankNameFromFinancialInstitutionIdentifier();

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFinancialInstitutionIdentifier() {
        return financialInstitutionIdentifier;
    }

    public void setFinancialInstitutionIdentifier(String financialInstitutionIdentifier) {
        this.financialInstitutionIdentifier = financialInstitutionIdentifier;
    }

    public String getFinancialInstitutionName() {
        return financialInstitutionName;
    }

    public void setFinancialInstitutionName(String financialInstitutionName) {
        this.financialInstitutionName = financialInstitutionName;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "accountNumber='" + accountNumber + '\'' +
                ", financialInstitutionIdentifier='" + financialInstitutionIdentifier + '\'' +
                ", financialInstitutionName='" + financialInstitutionName + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    @Override
    public Payment clone() {
        try {
            return (Payment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
