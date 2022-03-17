package com.example;

public class SleepHelper {
    public static void sleepMilliSecond(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
