package abstractFactory;

import abstractFactory.dto.payment.*;

public class USPaymentFactory {
    static Payment generatePayment(String accountNumber, String financialInstitutionIdentifier, String amount, boolean isRTP) throws Exception {
        Payment payment = new USPayment(accountNumber, financialInstitutionIdentifier);

        if(isRTP){
            payment.setPaymentType(new RTPPaymentType(6));
        }else{
            payment.setPaymentType(new ACHPaymentType(2));
        }

        payment.setAmount(amount);
        payment.setBankNameFromFinancialInstitutionIdentifier();

        return payment;
    }
}
