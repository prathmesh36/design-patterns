package adapter.dto.instruction;

import org.json.JSONObject;

import javax.xml.transform.TransformerException;

public class PaymentInstructionJSON{
    private JSONObject paymentInstruction;

    public PaymentInstructionJSON(){

    }

    public PaymentInstructionJSON(String paymentInstructionJsonStr){
        this.paymentInstruction = new JSONObject(paymentInstructionJsonStr);
    }

    public JSONObject getPaymentInstruction() throws TransformerException {
        return this.paymentInstruction;
    }
}
