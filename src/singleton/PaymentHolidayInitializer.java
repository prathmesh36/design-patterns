package singleton;

import singleton.dto.payment.PaymentHolidays;

import java.util.List;
import java.util.Map;

public class PaymentHolidayInitializer {
    PaymentHolidaySingleton paymentHolidaySingleton;

    public PaymentHolidayInitializer(Map<String, List<String>> holidaysByCountry){
        try {

            this.paymentHolidaySingleton = PaymentHolidaySingleton.getInstance(holidaysByCountry);
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPaymentHolidays(){
        System.out.println(this.paymentHolidaySingleton.paymentHolidays.toString());
    }
}
