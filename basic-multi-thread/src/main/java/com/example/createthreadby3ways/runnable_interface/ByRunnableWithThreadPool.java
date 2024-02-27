package com.example.createthreadby3ways.runnable_interface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

public class ByRunnableWithThreadPool {

    public static void main(String[] args) {
        @SuppressWarnings("all") //
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Using thread pool to create thread_t_1");
                //new ArrayList<>(0).get(1); // mocking throw index out of bound exception
            }
        });

        executorService.execute(
                () -> {
                System.out.println("Using thread pool to create thread_t_2");
            }
        );

        executorService.shutdown(); //线程池用完后要shutdown
    }

}
