package com.example.practice10;
/**
 * 线程类,线程启动后立即调用sleep()方法, 进入Timed Waiting 状态,休眠 0~5 秒钟随机时长,然后输出该随机时长.
 * 循环 10 次后线程退出.
 */
class DelayThread extends Thread{
    /**
     * 静态线程计数变量
     */
    private static int count = 0;
    /**
     * 用作线程编号
     */
    private int no;
    /**
     * 用作线程休眠时长
     */
    private int delay;
    public DelayThread() {
        count++;
        no = count;
    }

    /**
     * 调用sleep()方法, 进入Timed Waiting 状态,休眠 0~5 秒钟随机时长,然后输出该随机时长
     */
    public void run() {
        try {
            for (int i = 0; i < 10; i++) { //将循环体内的操作, 循环 10 次
                delay = (int) (Math.random() * 5000); //生成区间 [0 , 5000)之间的随机正整数
                sleep(delay); //休眠 delay 毫秒
                System.out.println("Thread " + no + " with a delay " + delay); //输出线程编号 和休眠时长
            }
        } catch (InterruptedException e) {
            //例程此处空白
        }
    }
}

/**
 * 启动类
 */
public class MyThread {
    /**
     * 主函数, 创建两个线程,并立即启动这 2 个线程,然后 main 线程休眠眠 1 秒钟后 main 线程退出
     * @param args
     */
    public static void main(String[] args) {
        DelayThread thread1 = new DelayThread(); //创建线程对象 thread1
        DelayThread thread2 = new DelayThread(); //创建线程对象 thread2
        thread1.start(); //启动线程 thread1
        thread2.start(); //启动线程 thread2
        try{
            Thread.sleep(1000); //休眠 1 秒钟之后,  main 线程直接退出; thread1, thread2 线程不受影响继续运行; 所有非 demon 线程结束后,JVM退出
        } catch (InterruptedException e) {
            System.out.println("Thread wrong");
        }
    }
}
