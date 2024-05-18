package facade;

import facade.dto.FormattingOperations;

import java.util.List;

public class PaymentProcessor {
    public PaymentProcessor(String paymentInstruction, Boolean isJson, List<FormattingOperations> formattingOperations){
        PaymentProcessorFacade paymentProcessorFacade = new PaymentProcessorFacade(paymentInstruction, isJson);
        System.out.println(paymentProcessorFacade.getFormattedPayment(formattingOperations));
    }
}
