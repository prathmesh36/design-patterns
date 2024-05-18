package flyweight.dto;

import java.util.List;

public class CountryPaymentDataFlyWeight {
    private List<String> nonProcessingDays;
    private String otherCountryData;

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
