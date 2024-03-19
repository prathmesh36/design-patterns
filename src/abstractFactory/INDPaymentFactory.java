package abstractFactory;

import abstractFactory.dto.payment.*;

public class INDPaymentFactory {
    static Payment generatePayment(String accountNumber, String financialInstitutionIdentifier, String amount, boolean isRTP) throws Exception {
        Payment payment = new INDPayment(accountNumber, financialInstitutionIdentifier);
        if(isRTP){
            payment.setPaymentType(new RTPPaymentType(4));
        }else{
            payment.setPaymentType(new ACHPaymentType(1));
        }

        payment.setAmount(amount);
        payment.setBankNameFromFinancialInstitutionIdentifier();

        return payment;
    }
}
