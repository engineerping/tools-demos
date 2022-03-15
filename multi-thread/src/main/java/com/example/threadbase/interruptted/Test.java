package com.example.threadbase.interruptted;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
//            while (!Thread.interrupted()) {
//            while (true) {
                try {
                    System.out.println("Hi, This is in sub thread..." + i++);
                    System.out.println("1 Is current thread interrupted: " + Thread.currentThread().isInterrupted());
                    Thread.sleep(2000);
                    System.out.println("2 Is current thread interrupted: " + Thread.currentThread().isInterrupted());
//
//                    if (i == 5) {
//                        Thread.currentThread().interrupt();
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //thread was interrupted during sleep or wait
                } finally {
                    //cleanup, if required
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(500);
        t.interrupt();
        System.out.println("3 Is current thread interrupted: " + t.isInterrupted());
    }
}
