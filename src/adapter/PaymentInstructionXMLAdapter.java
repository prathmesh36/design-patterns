package adapter;

import adapter.dto.instruction.PaymentInstructionJSON;
import adapter.dto.instruction.PaymentInstructionXML;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class PaymentInstructionXMLAdapter extends PaymentInstructionJSON {
    private PaymentInstructionXML paymentInstructionXML;


    public PaymentInstructionXMLAdapter(PaymentInstructionXML paymentInstructionXML) {
        this.paymentInstructionXML = paymentInstructionXML;
    }

    @Override
    public JSONObject getPaymentInstruction() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformer.transform(new DOMSource(this.paymentInstructionXML.getPaymentInstruction()), new StreamResult(stringWriter));
        return XML.toJSONObject(stringWriter.toString()).getJSONObject("Payment");
    }


}
