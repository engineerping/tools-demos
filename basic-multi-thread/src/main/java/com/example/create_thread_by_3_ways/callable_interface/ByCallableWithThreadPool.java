package com.example.create_thread_by_3_ways.callable_interface;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class ByCallableWithThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Boolean> callableBoolean_1 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                sleep(1000);
                new ArrayList<>(1).get(2); // mocking throw index out of bound exception
                System.out.println("Callable is creating thread_1");
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

        Callable<Boolean> callableBoolean_3 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                sleep(1000);
                //new ArrayList<>(1).get(2); // mocking throw index out of bound exception
                System.out.println("Callable is creating thread_3");
                return Boolean.TRUE;
            }
        };

        Callable<Boolean> callableBoolean_4 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("Callable is creating thread_2");
                return Boolean.TRUE;
            }
        };

        // 手动床加你线程传入执行 call 方法, 但是这个写法捕获不到 call 方法中的异常
        FutureTask<Boolean> futureTask_1 = new FutureTask<>(callableBoolean_1);
        FutureTask<Boolean> futureTask_2 = new FutureTask<>(callableBoolean_2);

        Thread thread_1 = new Thread(futureTask_1);
        Thread thread_2 = new Thread(futureTask_2);
        thread_1.start();
        thread_2.start();
        futureTask_1.get(); // main 线程调用这个get() 方法时, main线程会等待 futureTask_1.get() 方法执行完毕,也就是main线程被阻塞了
        futureTask_2.get();

        // 想要捕获call 方法中的异常,可以将 Callable 对象传递给线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<Boolean> futureTask_3 = executorService.submit(callableBoolean_1);
//        Future<Boolean> futureTask_4 = executorService.submit(callableBoolean_2);
//
//        futureTask_3.get(); // main 线程调用这个get() 方法时, main线程会等待 futureTask_1.get() 方法执行完毕,也就是main线程被阻塞了
//        futureTask_4.get();
//
//        executorService.shutdown(); //线程池用完后要shutdown

    }

}
