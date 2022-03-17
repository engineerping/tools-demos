package com.example.createthreadby3ways.runnable;

public class ImplementsRunnableOrLambda {
    public static void main(String[] args) {

        //implements Runnable
        Thread thread2_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Implement Runnable to create thread");
            }
        });


        //by lambda
        Thread thread2_2 = new Thread(
            () -> {
                System.out.println("Use lambda to simplify the action of implementing runnable to create threads");
            }
        );


        thread2_1.start();
        thread2_2.start();
    }

}
