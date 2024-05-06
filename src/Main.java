
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        switch (args[0]) {
            case "Factory" -> {
                new factory.PaymentProcessor("23789145", "021000021", "14.23", "US").displayPayment();
                new factory.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND").displayPayment();
            }
            case "AbstractFactory" -> {
                new abstractFactory.PaymentProcessor("23789145", "021000021", "14.23", "US", true).displayPayment();
                new abstractFactory.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND", true).displayPayment();
                new abstractFactory.PaymentProcessor("23789145", "021000021", "14.23", "US", false).displayPayment();
                new abstractFactory.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND", false).displayPayment();
            }
            case "Builder" -> {
                new builder.PaymentProcessor("23789145", "021000021", "14.23", "US").displayPayment();
                new builder.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND").displayPayment();
            }
            case "Prototype" -> {
                new prototype.PaymentProcessor("23789145", "14.23", "US").displayPayment();
                new prototype.PaymentProcessor("3378924521", "1500.00", "IND").displayPayment();
            }
            case "Singleton" -> {
                new singleton.PaymentHolidayInitializer(Map.of("US", Arrays.asList("04-JUL-2024", "01-MAY-2024"),
                        "IND",  Arrays.asList("05-SEP-2024", "15-NOV-2024"))).displayPaymentHolidays();
            }
            case "Adapter" -> {
                String jsonStrInstruction = "{\"accountNumber\":\"B23456789\",\"financialInstitutionIdentifier\":\"BOFA1234\",\"financialInstitutionName\":\"Bank of America\",\"amount\":\"100.00\"}";
                new adapter.PaymentProcessor(jsonStrInstruction, true).displayPayment();
                String xmlStrInstruction = "<Payment>\n" +
                        "    <accountNumber>J23456789</accountNumber>\n" +
                        "    <financialInstitutionIdentifier>JPM1234</financialInstitutionIdentifier>\n" +
                        "    <financialInstitutionName>JPMC</financialInstitutionName>\n" +
                        "    <amount>1000.00</amount>\n" +
                        "</Payment>";
                new adapter.PaymentProcessor(xmlStrInstruction, false).displayPayment();

            }
        }
    }
}