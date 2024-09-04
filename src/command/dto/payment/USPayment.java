package command.dto.payment;

public class USPayment extends Payment {

    public USPayment(String accountNumber, String financialInstitutionIdentifier) {
        setAccountNumber(accountNumber);
        setFinancialInstitutionIdentifier(financialInstitutionIdentifier);
    }

    @Override
    public void setBankNameFromFinancialInstitutionIdentifier() {
        setFinancialInstitutionName(getBankCode(getFinancialInstitutionIdentifier()));
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
