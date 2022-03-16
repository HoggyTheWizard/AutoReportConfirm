package com.hoggythewizard.utils;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void waitTime(int MS) {
        try
        {
            TimeUnit.MILLISECONDS.sleep(MS);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
