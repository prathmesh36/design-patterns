package adapter;

import adapter.dto.instruction.PaymentInstructionJSON;
import adapter.dto.payment.Payment;
import org.json.JSONObject;

import javax.xml.transform.TransformerException;

public class PaymentCaptureJSON {

    public static Payment captureJSONPayment(PaymentInstructionJSON paymentInstructionJson) throws TransformerException {
        return jsonInstructionToPaymentMapping(paymentInstructionJson.getPaymentInstruction());
    }

    private static Payment jsonInstructionToPaymentMapping(JSONObject paymentJSONObject){
        String accountNumber = paymentJSONObject.optString("accountNumber");
        String financialInstitutionIdentifier = paymentJSONObject.optString("financialInstitutionIdentifier");
        String financialInstitutionName = paymentJSONObject.optString("financialInstitutionName");
        String amount = paymentJSONObject.optString("amount");
        return new Payment(accountNumber, financialInstitutionIdentifier, financialInstitutionName, amount);
    }
}
