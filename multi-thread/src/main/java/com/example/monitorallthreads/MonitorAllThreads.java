package com.example.monitorallthreads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class MonitorAllThreads {
    public static void main(String[] args) {

    }

    private Map<String, List<String>> getCurrentThreadInfo() {
        final Map<String, List<String>>  resultMap = new HashMap<>();
        final Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        allStackTraces.forEach((k, v) -> {
            final StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("thread name=").append(k.getName());

            //Stream.of(v).filter(stackTrace1 -> stackTrace1.getClassName().startsWith());
        });
        return resultMap;
    }

}
