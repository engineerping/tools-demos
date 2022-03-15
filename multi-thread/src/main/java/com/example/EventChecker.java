package com.example;

public class EventChecker implements Runnable{
    private IntGenerator generator;
    private final int id;

    public EventChecker(IntGenerator generator, int ident) {
        this.generator = generator;
        this.id = ident;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
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
