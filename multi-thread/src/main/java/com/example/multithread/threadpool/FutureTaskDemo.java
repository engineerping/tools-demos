package com.example.multithread.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 1000;
        });

        new Thread(task).start(); //因为FutureTask 实现了Runable接口
        System.out.println("Before get");
        System.out.println(task.get());
        System.out.println("After get");
    }
}
