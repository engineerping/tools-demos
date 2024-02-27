package com.example;

import java.util.concurrent.TimeUnit;

public class SleepHelper {
    public static void sleepMilliSecond(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepSecond(long seconds) {
        try {
            //Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
