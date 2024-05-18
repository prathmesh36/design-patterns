package builder.dto.payment;

public class INDPayment extends Payment {


    public INDPayment(Builder builder){
        setAccountNumber(builder.getAccountNumber());
        setAmount(builder.getAmount());
        setFinancialInstitutionIdentifier(builder.getFinancialInstitutionIdentifier());
        setBankNameFromFinancialInstitutionIdentifier(builder.getFinancialInstitutionIdentifier());
    }


    @Override
    public void setBankNameFromFinancialInstitutionIdentifier(String financialInstitutionIdentifier) {
        setFinancialInstitutionName(financialInstitutionIdentifier.substring(0, 4));
    }
}
