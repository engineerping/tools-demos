package com.example.thread_in_order;

/**
 * @author gongchengship@163.com
 */
public class ThreadInOrder {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            System.out.println('A');
        });

        Thread b = new Thread(() -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println('B');
        });

        Thread c = new Thread(() -> {

            try {
                b.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println('C');
        });

        a.start();
        b.start();
        c.start();

    }
}
