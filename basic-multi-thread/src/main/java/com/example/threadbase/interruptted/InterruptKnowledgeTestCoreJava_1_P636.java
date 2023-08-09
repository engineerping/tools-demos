package com.example.threadbase.interruptted;

public class InterruptKnowledgeTestCoreJava_1_P636 {

    public static void main(String[] args) {
        Thread thread1 = new Thread( () -> {
            try {
            /*
            《Java Doc》
            在sleep期间,如果任何线程将当前线程的中断标志位设置,则会抛出InterruptedException异常时，此时当前线程的<i>中断状态<i>被清除。
             */
                Thread.sleep(2000);//阻塞当前线程的方式之一《Java核心技术I10thP636》
                System.out.println("(In try block) Is current thread interrupted: " + Thread.currentThread().isInterrupted());
                System.out.println("Hi this is in Thread1");
            } catch (InterruptedException e) {
            /*
            《Java核心技术I10thP636》
            如果一个阻塞的线程InterruptedException,就无法检测其中断状态,
            即调用Thread.currentThread().isInterrupted()方法

             */
                System.out.println("(In catch block) Is current thread interrupted: " + Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });

        thread1.start();

    }
}
