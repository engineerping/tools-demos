package com.example.threadbase;

import com.example.EventChecker;
import com.example.IntGenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventCheckerTest {
    public static void test(IntGenerator gp, int count) {
        System.out.println("Please shut down manually");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EventChecker(gp, i));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        test(new IntGenerator() {
            @Override
            public int next() {
                return 0;
            }
        }, 10);
    }
}
