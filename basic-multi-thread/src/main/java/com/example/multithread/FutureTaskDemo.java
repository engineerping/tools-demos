package com.example.multithread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 1000;
        });

        //因为FutureTask 实现了Runable接口,所以可以作为 Thread 的target,即构造函数参数
        new Thread(task).start();
        System.out.println("Before get");
        System.out.println(task.get());
        System.out.println("After get");
    }
}
