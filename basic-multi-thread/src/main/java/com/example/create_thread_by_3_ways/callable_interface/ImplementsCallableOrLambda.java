package com.example.create_thread_by_3_ways.callable_interface;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class ImplementsCallableOrLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask 实现了 Runnable 接口, 可以调用其 run() 方法
        FutureTask<Boolean> futureTaskBoolean_1 = new FutureTask<>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception { //call() 方法: 1.可以声明抛出异常; 2.可以有返回值
                sleep(500);
                System.out.println("Implement Callable to create thread ");
                //new ArrayList<>(0).get(1); // mocking throw index out of bound exception
                return Boolean.TRUE;
            }
        });
        Thread thread_1 = new Thread(futureTaskBoolean_1);
        thread_1.start();
        Boolean flag1 = futureTaskBoolean_1.get();
        System.out.println(flag1);

        //
        FutureTask<Boolean> futureTaskBoolean_2 = new FutureTask<>(
                () -> {
                    System.out.println("Use lambda to simplify the action of implementing Callable to create threads");
                    return Boolean.TRUE;
                }
        );

        Thread thread_2 = new Thread(futureTaskBoolean_2);
        thread_2.start();
        Boolean flag2 = futureTaskBoolean_2.get();
        System.out.println(flag2);
    }
}
