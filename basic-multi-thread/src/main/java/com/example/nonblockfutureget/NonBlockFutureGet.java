package com.example.nonblockfutureget;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class NonBlockFutureGet {
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

        Callable<Boolean> callableBoolean_3 = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("Callable is creating thread_3");
                return Boolean.TRUE;
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Boolean>> futureList = new ArrayList<>();
        futureList.add(executorService.submit(callableBoolean_1)); //submit 是异步的
        futureList.add(executorService.submit(callableBoolean_2));
        futureList.add(executorService.submit(callableBoolean_3));

        futureList.forEach((f) -> {
            try {
                f.get(); //get方法是阻塞的，会阻塞调用get() 方法的进程
            } catch (InterruptedException |ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
