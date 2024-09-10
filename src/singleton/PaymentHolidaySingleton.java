package singleton;

import singleton.dto.payment.PaymentHolidays;

import java.util.List;
import java.util.Map;

public class PaymentHolidaySingleton {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile PaymentHolidaySingleton instance;

    public PaymentHolidays paymentHolidays;

    private PaymentHolidaySingleton(Map<String, List<String>> holidaysByCountry) {
        PaymentHolidays paymentHolidays = new PaymentHolidays();
        paymentHolidays.setHolidaysByCountry(holidaysByCountry);
        this.paymentHolidays = paymentHolidays;
    }

    public static PaymentHolidaySingleton getInstance(Map<String, List<String>> holidaysByCountry) {
        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue
        PaymentHolidaySingleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized (PaymentHolidaySingleton.class) {
            if (instance == null) {
                instance = new PaymentHolidaySingleton(holidaysByCountry);
            }
            return instance;
        }
    }

}
