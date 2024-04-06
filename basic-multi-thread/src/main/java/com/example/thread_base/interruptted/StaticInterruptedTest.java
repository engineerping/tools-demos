package com.example.thread_base.interruptted;

import com.example.SleepHelper;

/**
 /**
 *###############################################################################
 *TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled
 *###############################################################################
 * @author: gcsp.
 * ##优雅地停止一个线程，要用死循环##
 * <p>
 * interrupt() 方法用于将线程的断标志位的值设置为true,线程每运行一步，都会主动去检查这个中断标志位的值。
 * isInterrupted() 方法用于读取线程的中断标志位的值,然后程序员根据自己的需要写自己的逻辑。
 * 另外，
 * static interrupted 用于读取线程的中断标志位的值，并将其设置为默认值false（重置）。
 */
public class StaticInterruptedTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (; ; ) { //1. 在线程的run 方法最外层开启一个死循环
                if (Thread.interrupted()) { //2.1:读取线程的中断标志位的值，看是true还是false，然后将这个boolean值暂存起来待用;2.2:将线程的中断标志位的值重新设置为默认值false;2.3:将步骤2.1中所暂存的boolean值返回
                    System.out.println("能进入当前if 块，说明Thread.interrupted()在if条件中的那一次被调用时返回值为 true");
                    System.out.println("再次用 Thread.interrupted()读取线程的中断标志位,其值为:");
                    System.out.println(Thread.interrupted());
                    System.out.println("FALSE说明Thread.interrupted()方法在判断完中断标志位,后把中断标志位的值设置为了默认值false,想学习工作流程是注释2.1,2.2,2.3所述");
                    System.out.println("进入这个if 块的唯一作用就是结束死循环，从而结束当前线程的...所以接下来就break");
                    break; //3.如果线程中断标志位被设置为了true，则break出整个循环。
                }

                //Do something...
                doSomething();
            }
        });

        thread1.start();
        SleepHelper.sleepMilliSecond(1000); //主线程sleep 1 秒钟

        thread1.interrupt(); //4.设置线程的中断标志位的值为 true
    }

    private static void doSomething() {
        System.out.println("Do something ...");
    }
}
