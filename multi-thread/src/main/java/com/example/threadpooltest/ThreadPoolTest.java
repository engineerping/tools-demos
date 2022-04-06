package com.example.threadpooltest;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class ThreadPoolTest {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            Runnable runnableObj = new Runnable() {
                @Override
                public void run() {
                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Callable is creating thread_1");
                    //new ArrayList<>(0).get(1); // mocking throw index out of bound exception
                }
            };

            Callable<Boolean> callableBoolean_2 = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    sleep(2000);
                    System.out.println("Callable is creating thread_2");
                    return Boolean.TRUE;
                }
            };

            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(runnableObj);
            Future<Boolean> futureTask_2 = executorService.submit(callableBoolean_2);

            try {
                sleep(1000);
                System.out.println("Main thread...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            futureTask_2.get();

            executorService.shutdown(); //线程池用完后要shutdown
    }
}
