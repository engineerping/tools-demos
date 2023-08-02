package com.example.deadlock;

public class Main {
//    public static Object resources1 = new Object();
//    public static Object resources2 = new Object();
//    public static void main(String[] args) {
//
//        new Thread(() -> {
//            // 线程1：占用资源1 ，请求资源2
//            synchronized(resources1) {
//                System.out.println("线程1已经占用了资源1，开始请求资源2");
//                try {
//                    Thread.sleep(2000);//休息两秒，防止线程1直接运行完成。
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                //2秒内线程2肯定可以锁住资源2
//                synchronized (resources2) {
//                    System.out.println("线程1已经占用了资源2");
//                }
//            }
//            }).start();
//        new Thread(() -> {
//                // 线程2：占用资源2 ，请求资源1
//                synchronized(resources2){
//                    System.out.println("线程2已经占用了资源2，开始请求资源1");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    synchronized (resources1){
//                        System.out.println("线程2已经占用了资源1");
//                    }
//                }
//        }).start();
//    }

//    static volatile int count = 10;
//    static final Object lock = new Object();
//    public static void main(String[] args) {
//        new Thread(() -> {
//            // 期望减到 0 退出循环
//            while (count > 0) {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                count--;
//                System.out.println("线程一count:" + count);
//            }
//        }, "t1").start();
//        new Thread(() -> {
//            // 期望超过 20 退出循环
//            while (count < 20) {
//                try {
//                    Thread.sleep(200);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                count++;
//                System.out.println("线程二count:"+ count);
//            }
//        }, "t2").start();
//    }

    static final Object room = new Object();
    static boolean hasCigarette = false;    //有没有烟
    static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (room) {
                System.out.println("有烟没？[{}]" + hasCigarette);
                while (!hasCigarette) {//while防止虚假唤醒
                    System.out.println("没烟，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有烟没？[{}]"+ hasCigarette);
                if (hasCigarette) {
                    System.out.println("可以开始干活了");
                } else {
                    System.out.println("没干成活...");
                }
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (room) {
                Thread thread = Thread.currentThread();
                System.out.println("外卖送到没？[{}]" + hasTakeout);
                if (!hasTakeout) {
                    System.out.println("没外卖，先歇会！");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("外卖送到没？[{}]" + hasTakeout);
                if (hasTakeout) {
                    System.out.println("可以开始干活了");
                } else {
                    System.out.println("没干成活...");
                }
            }
        }, "小女").start();


        Thread.sleep(1000);
        new Thread(() -> {
            // 这里能不能加 synchronized (room)？
            synchronized (room) {
                hasTakeout = true;
                //System.out.println("烟到了噢！");烟到了噢
//                System.out.println("外卖到了噢！");
                room.notifyAll();
            }
        }, "送外卖的").start();
    }
}