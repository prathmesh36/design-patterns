package builder.dto.payment;


abstract public class Payment {

    public static class Builder{
        private String accountNumber;
        private String financialInstitutionIdentifier;
        private String amount;
        private String countryCode;

        //Account Number is Mandatory
        public Builder(String accountNumber){
            this.accountNumber = accountNumber;
        }

        public Builder financialInstitutionIdentifier(String financialInstitutionIdentifier){
            this.financialInstitutionIdentifier = financialInstitutionIdentifier;
            return this;
        }


        public Builder countryCode(String countryCode){
            this.countryCode = countryCode;
            return this;
        }

        public Builder amount(String amount){
            this.amount = amount;
            return this;
        }

        public Payment build() throws Exception {
            return switch (this.countryCode) {
                case "IND" -> new INDPayment(this);
                case "US" -> new USPayment(this);
                default -> throw new Exception();
            };
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

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }
    }

    private String accountNumber;
    private String financialInstitutionIdentifier;
    private String financialInstitutionName;
    private String amount;

    public abstract void setBankNameFromFinancialInstitutionIdentifier(String financialInstitutionIdentifier);

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
}
