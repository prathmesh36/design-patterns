package builder.dto.payment;

public class USPayment extends Payment {

    public USPayment(Builder builder){
        setAccountNumber(builder.accountNumber);
        setAmount(builder.amount);
        setFinancialInstitutionIdentifier(builder.financialInstitutionIdentifier);
        setBankNameFromFinancialInstitutionIdentifier(builder.financialInstitutionIdentifier);
    }


    @Override
    public void setBankNameFromFinancialInstitutionIdentifier(String financialInstitutionIdentifier) {
        setFinancialInstitutionName(getBankCode(financialInstitutionIdentifier));
    }

    private static String getBankCode(String routingNumber) {
        return switch (routingNumber) {
            case "021000021" -> "JPM";
            case "026009593" -> "BOA";
            case "021001208" -> "WFA";
            default -> "XXX";
        };
    }
}
