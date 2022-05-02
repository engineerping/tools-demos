package com.example.waitnotify;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 */
public class WaitNotify {
    static boolean flag = true;
    static Object obj = new Object();

    public static void main(String[] args) {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁，拥有obj 的 monitor
            synchronized (obj) {
                //当条件不满足时，继续wait, 同时释放了obj 的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + "flag is true. wait @" +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));

                        obj.wait();
                    } catch (InterruptedException e) {
                        //Do nothing
                    }
                }

                //条件满足时，完成工作
                System.out.println(Thread.currentThread() + "flag is true. wait @" +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {

        }
    }
}
