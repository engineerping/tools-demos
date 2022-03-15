package com.example.synchronizedtest;

import com.example.IntGenerator;

public class SynchronizedEventGenerator extends IntGenerator {
    private int currentEventValue = 0;
    @Override
    public synchronized int next() {
        ++currentEventValue;

        ++currentEventValue;
        return 0;
    }
}
