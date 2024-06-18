package strategy;


import strategy.dto.Payment;

import javax.xml.parsers.ParserConfigurationException;

public class PaymentProcessor {

    public void displayPayment(Payment payment, String displayTypeCode) {
        try {
            PaymentDisplayStrategy paymentDisplayStrategy = switch (displayTypeCode) {
                case "JSON" -> new PaymentDisplayStrategyJSON();
                case "XML" -> new PaymentDisplayStrategyXML();
                default -> throw new Exception();
            };
            System.out.println(paymentDisplayStrategy.display(payment));
        }catch(Exception e){
            System.out.println("Not a valid payment or display type");
        }
    }
}
