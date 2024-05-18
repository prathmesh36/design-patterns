package facade;

import adapter.PaymentCaptureJSON;
import adapter.PaymentInstructionXMLAdapter;
import adapter.dto.instruction.PaymentInstructionJSON;
import adapter.dto.instruction.PaymentInstructionXML;
import adapter.dto.payment.Payment;
import decorator.dto.PaymentGetter;
import decorator.dto.PaymentGetterCompressorDecorator;
import decorator.dto.PaymentGetterEncoderDecorator;
import decorator.dto.SimplePaymentGetter;
import facade.dto.FormattingOperations;

import java.util.List;

public class PaymentProcessorFacade {
    private Payment payment;
    public PaymentProcessorFacade(String paymentInstruction, Boolean isJson){
        System.out.println("Payment Instruction received: " + paymentInstruction);
        try {
            PaymentInstructionJSON paymentInstructionJSON;
            if(isJson){
                paymentInstructionJSON = new PaymentInstructionJSON(paymentInstruction);
            }else{
                PaymentInstructionXML paymentInstructionXML = new PaymentInstructionXML(paymentInstruction);
                paymentInstructionJSON = new PaymentInstructionXMLAdapter(paymentInstructionXML);
            }
            this.payment = PaymentCaptureJSON.captureJSONPayment(paymentInstructionJSON);
            System.out.println("Parsed Payment Object: " + this.payment.toString());
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public String getFormattedPayment(List<FormattingOperations> formattingOperations){
        PaymentGetter paymentGetter = new SimplePaymentGetter();
        for(FormattingOperations formattingOperation: formattingOperations){
            if(formattingOperation == FormattingOperations.ENCODE){
                PaymentGetter paymentGetterNew = new PaymentGetterEncoderDecorator(paymentGetter);
                paymentGetter = paymentGetterNew;
            }else if(formattingOperation == FormattingOperations.COMPRESS) {
                PaymentGetter paymentGetterNew = new PaymentGetterCompressorDecorator(paymentGetter);
                paymentGetter = paymentGetterNew;
            }
        }
        return paymentGetter.getPayment(payment.toString());
    }
}
