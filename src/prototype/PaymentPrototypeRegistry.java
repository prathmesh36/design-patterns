package prototype;

import prototype.dto.payment.INDPayment;
import prototype.dto.payment.Payment;
import prototype.dto.payment.USPayment;

import java.util.HashMap;

public class PaymentPrototypeRegistry {
    private final HashMap<String, Payment> paymentPrototypes = new HashMap<String, Payment>();

    public PaymentPrototypeRegistry(){
        loadPaymentPrototypes();
    }

    public Payment createPayment(String countryCode){
        try{
            return paymentPrototypes.get(countryCode).clone();
        }catch (Exception ex){
            throw new RuntimeException();
        }
    }

    // financialInstitutionIdentifier is fix for US and IND so can be obtained form the clone.
    private void loadPaymentPrototypes(){
        Payment indPayment = new INDPayment("XXXXXXXX", "BOFAIND01");
        Payment usPayment = new USPayment("XXXXXXXX", "026009593");
        paymentPrototypes.put("US", usPayment);
        paymentPrototypes.put("IND", indPayment);
    }
}
