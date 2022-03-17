package com.example.createthreadby3ways.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class ImplementsCallableOeLambda {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Boolean> futureTaskBoolean_1 = new FutureTask<>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                sleep(1000);
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
