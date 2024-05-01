package singleton;

import singleton.dto.payment.PaymentHolidays;

public class PaymentHolidaySingleton {
    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile PaymentHolidaySingleton instance;

    public PaymentHolidays paymentHolidays;

    private PaymentHolidaySingleton(PaymentHolidays paymentHolidays) {
        this.paymentHolidays = paymentHolidays;
    }

    public static PaymentHolidaySingleton getInstance(PaymentHolidays paymentHolidays) {
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
                instance = new PaymentHolidaySingleton(paymentHolidays);
            }
            return instance;
        }
    }

}
