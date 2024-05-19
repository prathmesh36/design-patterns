package flyweight;

import flyweight.dto.CountryPaymentDataFlyWeight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryFlyWeightFactory {
    static Map<String, CountryPaymentDataFlyWeight> countryDataFlyWeight = new HashMap<>();

    public static CountryPaymentDataFlyWeight getCountryDataFlyWeight(String countryCode, List<String> nonProcessingDays, String otherCountryData) {
        CountryPaymentDataFlyWeight result = countryDataFlyWeight.get(countryCode);
        if (result == null) {
            result = new CountryPaymentDataFlyWeight(countryCode, nonProcessingDays, otherCountryData);
            countryDataFlyWeight.put(countryCode, result);
        }
        return result;
    }
}
