
import bridge.AccountProcessor;
import bridge.constant.Account;
import bridge.constant.Country;
import composite.LedgerProcessor;
import composite.dto.CompositeTransaction;
import composite.dto.CreditTransaction;
import composite.dto.DebitTransaction;
import composite.dto.TransactionImpl;
import facade.dto.FormattingOperations;
import flyweight.BatchPaymentProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No arguments passed");
        }

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
            case "Bridge" -> {
                new AccountProcessor("123456789","HDFC123", 15, Country.IND, Account.SAVINGS);
                new AccountProcessor("123456789","HDFC123", 15, Country.IND, Account.CHECKING);
                new AccountProcessor("123456789","JPMC123", 15, Country.US, Account.SAVINGS);
                new AccountProcessor("123456789","JPMC123", 15, Country.US, Account.CHECKING);
                new AccountProcessor("123456789","JPMC123", 19, Country.US, Account.CHECKING);
            }
            case "Composite" -> {
                CompositeTransaction compositeTransactionBene1 = new CompositeTransaction( "Bene1",Arrays.asList(new DebitTransaction(25), new CreditTransaction(30)));
                CompositeTransaction compositeTransactionBene2 = new CompositeTransaction( "Bene2",Arrays.asList(new DebitTransaction(100), new CreditTransaction(30)));
                List<TransactionImpl> allTransactions = Arrays.asList( compositeTransactionBene1, compositeTransactionBene2, new DebitTransaction(30));
                new LedgerProcessor("Overall", allTransactions).getBalance();
                compositeTransactionBene1 = new CompositeTransaction( "Bene1",Arrays.asList(new DebitTransaction(25), new CreditTransaction(130)));
                compositeTransactionBene2 = new CompositeTransaction( "Bene2",Arrays.asList(new DebitTransaction(10), new CreditTransaction(30)));
                allTransactions = Arrays.asList( compositeTransactionBene1, compositeTransactionBene2, new DebitTransaction(30));
                new LedgerProcessor("Overall", allTransactions).getBalance();
            }
            case "Decorator" -> {
                new decorator.PaymentProcessor("23789145", "021000021", "JPMC","14.23").displayPayment();
            }
            case "Facade" -> {
                String jsonStrInstruction = "{\"accountNumber\":\"B23456789\",\"financialInstitutionIdentifier\":\"BOFA1234\",\"financialInstitutionName\":\"Bank of America\",\"amount\":\"100.00\"}";
                new facade.PaymentProcessor(jsonStrInstruction, true, Arrays.asList());
                new facade.PaymentProcessor(jsonStrInstruction, true, Arrays.asList(FormattingOperations.ENCODE));
                new facade.PaymentProcessor(jsonStrInstruction, true, Arrays.asList(FormattingOperations.COMPRESS));
                new facade.PaymentProcessor(jsonStrInstruction, true, Arrays.asList(FormattingOperations.ENCODE, FormattingOperations.COMPRESS));
                new facade.PaymentProcessor(jsonStrInstruction, true, Arrays.asList(FormattingOperations.ENCODE, FormattingOperations.COMPRESS));
                String xmlStrInstruction = "<Payment>\n" +
                        "    <accountNumber>J23456789</accountNumber>\n" +
                        "    <financialInstitutionIdentifier>JPM1234</financialInstitutionIdentifier>\n" +
                        "    <financialInstitutionName>JPMC</financialInstitutionName>\n" +
                        "    <amount>1000.00</amount>\n" +
                        "</Payment>";
                new facade.PaymentProcessor(xmlStrInstruction, false, Arrays.asList());
                new facade.PaymentProcessor(xmlStrInstruction, false, Arrays.asList(FormattingOperations.ENCODE));
                new facade.PaymentProcessor(xmlStrInstruction, false, Arrays.asList(FormattingOperations.COMPRESS));
                new facade.PaymentProcessor(xmlStrInstruction, false, Arrays.asList(FormattingOperations.COMPRESS, FormattingOperations.ENCODE));
                new facade.PaymentProcessor(xmlStrInstruction, false, Arrays.asList(FormattingOperations.ENCODE, FormattingOperations.COMPRESS));
            }
            case "FlyWeight" -> {
                BatchPaymentProcessor batchPaymentProcessor = new flyweight.BatchPaymentProcessor();
                batchPaymentProcessor.addPaymentInBatch("23789145", "021000021", "JPMC","14.23", "USA", Arrays.asList("04-JUL-2024", "01-MAY-2024"), "NA");
                batchPaymentProcessor.addPaymentInBatch("23789775", "021434002", "BOFA","1234.23", "USA", Arrays.asList("04-JUL-2024", "01-MAY-2024"), "NA");
                batchPaymentProcessor.addPaymentInBatch("35789145", "021035031", "HDFC","1674.23", "IND", Arrays.asList("05-SEP-2024", "15-NOV-2024"), "NA");
                batchPaymentProcessor.addPaymentInBatch("35789365", "021634011", "AXIS","5.23", "IND", Arrays.asList("05-SEP-2024", "15-NOV-2024"), "NA");
                batchPaymentProcessor.displayPayment();
            }
            case "Proxy" -> {
                new proxy.PaymentProcessor(new proxy.dto.Payment("23789145", "021000021", "JPMC","14.23")).publishPayment();
            }
            case "Strategy" -> {
                new strategy.PaymentProcessor().displayPayment(new strategy.dto.Payment("23789145", "021000021", "JPMC","14.23"), "XML");
                new strategy.PaymentProcessor().displayPayment(new strategy.dto.Payment("23789145", "021000021", "JPMC","14.23"), "JSON");
            }
            case "ChainOfResponsibility" -> {
                new chainOfResponsibility.PaymentProcessor().processPayment("3378924521", "SBIN1234", "1500.00");
            }
            case "Iterator" -> {
                new iterator.PaymentProcessor().processPayment();
            }
            case "Observer" -> {
                new observer.PaymentProcessor().process("3378924521", "SBIN1234", "1500.00");
            }
        }
    }
}