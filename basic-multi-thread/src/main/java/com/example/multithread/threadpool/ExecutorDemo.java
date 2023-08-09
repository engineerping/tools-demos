package com.example.multithread.threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "Hello Callable";
            }
        };
        System.out.println("Get instance of ExecutorService");
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("Already got instance of ExecutorService");
        Future<String> future = executorService.submit(callable); //异步执行,主线程不用等待就继续执行
        System.out.println("Before get");
        System.out.println(future.get()); //future.get() 方法是阻塞的
        System.out.println("After get");

        executorService.shutdown();
    }
}
