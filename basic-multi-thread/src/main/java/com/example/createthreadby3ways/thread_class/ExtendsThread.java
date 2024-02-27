package com.example.createthreadby3ways.thread_class;

/**
 * Not suggested
 */
public class ExtendsThread extends Thread{
    @Override
    public void run() {
        System.out.println("Extends thread to create thread...");
    }

    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        thread.start();
    }
}
