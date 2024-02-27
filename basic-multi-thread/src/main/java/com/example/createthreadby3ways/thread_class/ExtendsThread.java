package com.example.createthreadby3ways.thread_class;

/**
 * Not suggested
 */
public class ExtendsThread extends Thread{
    @Override
    public void run() {
        try { // run() 方法: 1.不能声明抛出异常; 2.无返回值
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Extends thread to create thread...");
        //new ArrayList<>(0).get(1); // mocking throw index out of bound exception
    }

    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        thread.start();
    }
}
