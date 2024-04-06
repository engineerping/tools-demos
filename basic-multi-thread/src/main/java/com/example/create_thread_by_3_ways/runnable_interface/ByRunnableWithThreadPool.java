package com.example.create_thread_by_3_ways.runnable_interface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                //new ArrayList<>(1).get(2); // mocking throw index out of bound exception
                System.out.println("Using thread pool to create thread_t_1");
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
