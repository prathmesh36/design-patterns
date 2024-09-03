package observer.dto;

public class INDPayment extends Payment {

    public INDPayment(String accountNumber, String financialInstitutionIdentifier) {
        setAccountNumber(accountNumber);
        setFinancialInstitutionIdentifier(financialInstitutionIdentifier);
    }

    @Override
    public void setBankNameFromFinancialInstitutionIdentifier() {
        setFinancialInstitutionName(getFinancialInstitutionIdentifier().substring(0, 4));
    }
}
