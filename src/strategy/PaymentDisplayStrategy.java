package strategy;

import strategy.dto.Payment;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface PaymentDisplayStrategy {
    public String display(Payment payment) throws ParserConfigurationException, TransformerException;
}
