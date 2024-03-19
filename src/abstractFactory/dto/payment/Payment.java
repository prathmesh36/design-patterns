package abstractFactory.dto.payment;

abstract public class Payment {
    String accountNumber;
    String financialInstitutionIdentifier;
    String financialInstitutionName;
    String amount;
    PaymentType paymentType;

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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "accountNumber='" + accountNumber + '\'' +
                ", financialInstitutionIdentifier='" + financialInstitutionIdentifier + '\'' +
                ", financialInstitutionName='" + financialInstitutionName + '\'' +
                ", amount='" + amount + '\'' +
                ", paymentType=" + paymentType.toString() +
                '}';
    }
}
