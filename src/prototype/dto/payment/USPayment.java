package prototype.dto.payment;

public class USPayment extends Payment {

    public USPayment(String accountNumber, String financialInstitutionIdentifier) {
        this.accountNumber = accountNumber;
        this.financialInstitutionIdentifier = financialInstitutionIdentifier;
    }

    @Override
    public void setBankNameFromFinancialInstitutionIdentifier() {
        setFinancialInstitutionName(getBankCode(this.financialInstitutionIdentifier));
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
