package flyweight.dto;

import java.util.List;

public class CountryPaymentDataFlyWeight {
    private String countryCode;
    private List<String> nonProcessingDays;
    private String otherCountryData;

    public CountryPaymentDataFlyWeight(String countryCode, List<String> nonProcessingDays, String otherCountryData) {
        this.countryCode = countryCode;
        this.nonProcessingDays = nonProcessingDays;
        this.otherCountryData = otherCountryData;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<String> getNonProcessingDays() {
        return nonProcessingDays;
    }

    public void setNonProcessingDays(List<String> nonProcessingDays) {
        this.nonProcessingDays = nonProcessingDays;
    }

    public String getOtherCountryData() {
        return otherCountryData;
    }

    public void setOtherCountryData(String otherCountryData) {
        this.otherCountryData = otherCountryData;
    }
}
