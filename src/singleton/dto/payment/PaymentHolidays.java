package singleton.dto.payment;

import java.util.List;
import java.util.Map;

public class PaymentHolidays {
    public Map<String, List<String>> holidaysByCountry;

    public Map<String, List<String>> getHolidaysByCountry() {
        return holidaysByCountry;
    }

    public void setHolidaysByCountry(Map<String, List<String>> holidaysByCountry) {
        this.holidaysByCountry = holidaysByCountry;
    }

    @Override
    public String toString() {
        return "PaymentHolidays{" +
                "holidaysByCountry='" + holidaysByCountry.toString() + '\'' +
                '}';
    }
}
