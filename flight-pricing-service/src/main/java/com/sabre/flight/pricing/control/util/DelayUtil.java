package com.sabre.flight.pricing.control.util;

public class DelayUtil {
    public static void pauseThread(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
