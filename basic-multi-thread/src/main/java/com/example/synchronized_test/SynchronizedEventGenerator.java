package com.example.synchronized_test;

import com.example.volatile_useage.IntGenerator;

/**
 * 参考视频:
 * https://www.bilibili.com/video/BV1e841197A5/?p=164&spm_id_from=pageDriver
 */
public class SynchronizedEventGenerator extends IntGenerator {
    private int currentEventValue = 0;
    @Override
    public synchronized int next() {
        ++currentEventValue;

        ++currentEventValue;
        return 0;
    }
}
