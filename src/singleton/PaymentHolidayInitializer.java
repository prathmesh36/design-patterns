package singleton;

import java.util.List;
import java.util.Map;

public class PaymentHolidayInitializer {

    public PaymentHolidaySingleton getPaymentHolidaySingleton(Map<String, List<String>> holidaysByCountry){
        try {
            return PaymentHolidaySingleton.getInstance(holidaysByCountry);

        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
        return null;
    }

    public PaymentHolidaySingleton getPaymentHolidaySingleton(){
        try {
            return PaymentHolidaySingleton.getInstance();

        } catch (Exception e) {
            System.out.println("Return Exception Code");
        }
        return null;
    }

    public void displayPaymentHolidays(PaymentHolidaySingleton paymentHolidaySingleton){
        System.out.println(paymentHolidaySingleton.returnHolidays());
    }
}
