package singleton;

import singleton.dto.payment.PaymentHolidays;

import java.util.List;
import java.util.Map;

public class PaymentHolidayInitializer {
    PaymentHolidaySingleton paymentHolidaySingleton;

    public PaymentHolidayInitializer(Map<String, List<String>> holidaysByCountry){
        try {
            PaymentHolidays paymentHolidays = new PaymentHolidays();
            paymentHolidays.setHolidaysByCountry(holidaysByCountry);
            this.paymentHolidaySingleton = PaymentHolidaySingleton.getInstance(paymentHolidays);
        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
    }

    public void displayPaymentHolidays(){
        System.out.println(this.paymentHolidaySingleton.paymentHolidays.toString());
    }
}
