package com.example.createthreadby3ways.callable_interface;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ByCallableWithThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Boolean> callableBoolean_1 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                sleep(1000);
                System.out.println("Callable is creating thread_1");
                //new ArrayList<>(0).get(1); // mocking throw index out of bound exception
                return Boolean.TRUE;
            }
        };

        Callable<Boolean> callableBoolean_2 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("Callable is creating thread_2");
                return Boolean.TRUE;
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Boolean> futureTask_1 = executorService.submit(callableBoolean_1);
        Future<Boolean> futureTask_2 = executorService.submit(callableBoolean_2);

        futureTask_1.get();
        futureTask_2.get();

        executorService.shutdown(); //线程池用完后要shutdown

    }

}
