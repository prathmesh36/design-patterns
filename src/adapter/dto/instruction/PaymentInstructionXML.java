package adapter.dto.instruction;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

public class PaymentInstructionXML {
    private Document paymentInstruction;

    public PaymentInstructionXML(String paymentInstructionXMLStr) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.paymentInstruction = builder.parse(new InputSource(new StringReader(paymentInstructionXMLStr)));
    }

    public Document getPaymentInstruction() {
        return this.paymentInstruction;
    }
}
