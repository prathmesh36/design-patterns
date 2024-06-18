package strategy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import strategy.dto.Payment;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class PaymentDisplayStrategyXML implements PaymentDisplayStrategy{
    @Override
    public String display(Payment payment) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("payment");
        doc.appendChild(rootElement);

        Element accountNumber = doc.createElement("accountNumber");
        accountNumber.appendChild(doc.createTextNode(payment.getAccountNumber()));
        rootElement.appendChild(accountNumber);

        Element financialInstitutionIdentifier = doc.createElement("financialInstitutionIdentifier");
        financialInstitutionIdentifier.appendChild(doc.createTextNode(String.valueOf(payment.getFinancialInstitutionIdentifier())));
        rootElement.appendChild(financialInstitutionIdentifier);

        Element financialInstitutionName = doc.createElement("financialInstitutionName");
        financialInstitutionName.appendChild(doc.createTextNode(payment.getFinancialInstitutionName()));
        rootElement.appendChild(financialInstitutionName);

        Element amount = doc.createElement("amount");
        amount.appendChild(doc.createTextNode(payment.getAmount()));
        rootElement.appendChild(amount);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(domSource, result);
        return writer.toString();
    }
}
