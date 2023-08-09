package com.example.volatileuseage;

public class EventChecker implements Runnable{
    private IntGenerator generator;
    private final int id;

    public EventChecker(IntGenerator generator, int ident) {
        this.generator = generator;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if(val % 2 != 0) {
                System.out.println(val + " not event!");
                generator.cancel();
            }
        }
    }
}
