package flyweight.dto;

public class Payment {
    private String accountNumber;
    private String financialInstitutionIdentifier;
    private String financialInstitutionName;
    private String amount;
    private CountryPaymentDataFlyWeight countryPaymentDataFlyWeight;

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

    public CountryPaymentDataFlyWeight getCountryPaymentDataFlyWeight() {
        return countryPaymentDataFlyWeight;
    }

    public void setCountryPaymentDataFlyWeight(CountryPaymentDataFlyWeight countryPaymentDataFlyWeight) {
        this.countryPaymentDataFlyWeight = countryPaymentDataFlyWeight;
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
}
