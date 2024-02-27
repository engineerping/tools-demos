package com.example.createthreadby3ways.runnable_interface;

import static java.lang.Thread.sleep;

public class ImplementsRunnableOrLambda {
    public static void main(String[] args) {

        //implements Runnable
        Thread thread2_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try { // run() 方法: 1.不能声明抛出异常; 2.无返回值
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Implement Runnable to create thread...");
                //new ArrayList<>(0).get(1); // mocking throw index out of bound exception
            }
        });


        //by lambda
        Thread thread2_2 = new Thread(
            () -> {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Use lambda to simplify the action of implementing runnable to create threads");
            }
        );


        thread2_1.start();
        thread2_2.start();
    }

}
