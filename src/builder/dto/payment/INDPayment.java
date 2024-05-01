package builder.dto.payment;

public class INDPayment extends Payment {


    public INDPayment(Builder builder){
        setAccountNumber(builder.accountNumber);
        setAmount(builder.amount);
        setFinancialInstitutionIdentifier(builder.financialInstitutionIdentifier);
        setBankNameFromFinancialInstitutionIdentifier(builder.financialInstitutionIdentifier);
    }


    @Override
    public void setBankNameFromFinancialInstitutionIdentifier(String financialInstitutionIdentifier) {
        setFinancialInstitutionName(financialInstitutionIdentifier.substring(0, 4));
    }
}
