package com.example.thread_base.interruptted;

import com.example.SleepHelper;

 /**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 *
 * 优雅地停止一个线程，要用死循环
 *
 * interrupt() 方法用于将线程的断标志位的值设置为true,线程每运行一步，都会主动去检查这个中断标志位的值。
 * isInterrupted() 方法用于读取线程的中断标志位的值,然后程序员根据自己的需要写自己的逻辑。
 * static interrupted 用于读取线程的中断标志位的值，并将其设置为默认值false（重置）。
 */
public class InterruptForSet_IsInterruptedForReadTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (; ; ) { //1. 在线程的run 方法最外层开启一个死循环
                if (Thread.currentThread().isInterrupted()) { //2.读取线程的中断标志位的值，看是否已经被设置成了true
                    System.out.println("用Thread.currentThread().isInterrupted() 读取线程中断标志位,其值为: ");
                    System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println("进入这个if 块的唯一作用就是结束死循环，从而结束当前线程的...所以接下来就break");
                    break; //3.如果线程中断标志位被设置为了true，则break出整个循环，run方法直接结束，线程安全停止。
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
