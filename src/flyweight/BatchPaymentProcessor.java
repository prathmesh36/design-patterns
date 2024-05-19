package flyweight;

import flyweight.dto.CountryPaymentDataFlyWeight;
import flyweight.dto.Payment;

import java.util.ArrayList;
import java.util.List;

public class BatchPaymentProcessor {
    private List<Payment> paymentBatch = new ArrayList<>();

    public void addPaymentInBatch(String accountNumber, String financialInstitutionIdentifier, String financialInstitutionName, String amount, String countryCode, List<String> nonProcessingDays, String otherCountryData) {
        CountryPaymentDataFlyWeight countryDataFlyWeight = CountryFlyWeightFactory.getCountryDataFlyWeight(countryCode, nonProcessingDays, otherCountryData);
        Payment payment = new Payment(accountNumber, financialInstitutionIdentifier, financialInstitutionName, amount, countryDataFlyWeight);
        paymentBatch.add(payment);
    }

    public void displayPayment(){
        for(Payment payment: paymentBatch){
            System.out.println(payment.toString());
        }
    }
}
