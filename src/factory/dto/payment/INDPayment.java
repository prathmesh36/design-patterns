package factory.dto.payment;

public class INDPayment extends Payment {

    public INDPayment(String accountNumber, String financialInstitutionIdentifier) {
        this.accountNumber = accountNumber;
        this.financialInstitutionIdentifier = financialInstitutionIdentifier;
    }

    @Override
    public void setBankNameFromFinancialInstitutionIdentifier() {
        setFinancialInstitutionName(this.financialInstitutionIdentifier.substring(0, 4));
    }
}
