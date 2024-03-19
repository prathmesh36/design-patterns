
public class Main {
    public static void main(String[] args) {
        switch (args[0]){
            case "Factory":
                new factory.PaymentProcessor("23789145", "021000021", "14.23", "US").displayPayment();
                new factory.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND").displayPayment();
            case "AbstractFactory":
                new abstractFactory.PaymentProcessor("23789145", "021000021", "14.23", "US", true).displayPayment();
                new abstractFactory.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND", true).displayPayment();
                new abstractFactory.PaymentProcessor("23789145", "021000021", "14.23", "US", false).displayPayment();
                new abstractFactory.PaymentProcessor("3378924521", "SBIN1234", "1500.00", "IND", false).displayPayment();
        }
    }
}