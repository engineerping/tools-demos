package com.example.thread_unsafe_test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gongchengship@163.com
 * <p>
 * 参考: https://www.cnblogs.com/fnlingnzb-learner/p/13280493.html
 */
public class SimpleDateFormatTest {
    /**
     * 每 new 一个 SimpleDateFormatTest 对象, 都有一个独立的 simpleDateFormat 对象
     */
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static AtomicInteger count = new AtomicInteger(0);

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            10,
            10,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(100),
            new MyThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        /**
         * 放在这里,test 就是一个在堆内存中唯一一份的共享变量,会被各个线程共享,format 方法 的 calendar 变量存在被写入的情况,故有线程安全问题
         */
        SimpleDateFormatTest test = new SimpleDateFormatTest();

        while (count.get() < 5) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() { // run 方法不能抛出异常, run 方法中的异常会导致当前线程退出.
                    try {
                        int i = count.incrementAndGet(); //这就是一个 锁, 我就想让它执行不超过 5次
                        /**
                         * 放在这里,它就是每个线程的调用栈里面自己存一份 test 变量,format 方法 的 calendar 变量存在被写入的情况,故有线程安全问题
                         */
                        // SimpleDateFormatTest test = new SimpleDateFormatTest();

                        String dateString1 = test.simpleDateFormat.format(new Date()); //应用simpleDateFormat 转换 Date --> String
                        Date theSameDate = test.simpleDateFormat.parse(dateString1); // 应用simpleDateFormat 转换 String --> Date
                        String dateString2 = test.simpleDateFormat.format(theSameDate); // 应用simpleDateFormat 转换 Date --> String
                        System.out.println(dateString1.equals(dateString2) + " " + i); //多执行几遍,如果出现 false 说明线程不安全.

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }


    static class MyThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            return new Thread(r, "test-thread-pool");
        }
    }

    ;

}
