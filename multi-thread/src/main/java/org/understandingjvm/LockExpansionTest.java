package org.understandingjvm;

import org.openjdk.jol.info.ClassLayout;

public class LockExpansionTest {
    public static void main(String[] args) {
        LockExpansionTest lock = new LockExpansionTest();

        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 10 ; i++) {
                System.out.println(ClassLayout.parseInstance(lock).toPrintable());
            }
        });


//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Thread.yield();

        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10 ; i++) {
                lock.print();
            }
        });

//        t1.setDaemon(true);
        t1.start();
        t2.start();
    }

    private synchronized void print() {
        System.out.println(this.hashCode());
    }

}
