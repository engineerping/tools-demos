package com.example.thread_base.sleepandisinterrupt;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        t1.start();
        try {
            java.lang.Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Before interrupt, isInterrupted: " + t1.isInterrupted()); //false
//        /*
//        在正在sleep的t1线程上调用interrupt()方法,
//        将会抛出InterruptedException,然后在catch块中可以发现t1的中断状态被重新设置回false(t1.isInterrupted()值变成了false)
//         */
//        t1.interrupt();
//        System.out.println("After interrupt, isInterrupted: " + t1.isInterrupted()); //true
//        Thread.interrupted();
        System.out.println("Hi, this is in Main Thread");
    }
}
