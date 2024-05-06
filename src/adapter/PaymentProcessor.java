package adapter;

import adapter.dto.instruction.PaymentInstructionJSON;
import adapter.dto.instruction.PaymentInstructionXML;
import adapter.dto.payment.Payment;

public class PaymentProcessor {
    Payment payment;
    public PaymentProcessor(String paymentInstruction, Boolean isJson){
        try {
            PaymentInstructionJSON paymentInstructionJSON;
            if(isJson){
                paymentInstructionJSON = new PaymentInstructionJSON(paymentInstruction);
            }else{
                PaymentInstructionXML paymentInstructionXML = new PaymentInstructionXML(paymentInstruction);
                paymentInstructionJSON = new PaymentInstructionXMLAdapter(paymentInstructionXML);
            }
            this.payment = PaymentCaptureJSON.captureJSONPayment(paymentInstructionJSON);
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPayment(){
        System.out.println(this.payment.toString());
    }
}
