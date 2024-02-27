package com.example.thread_local;

import java.util.concurrent.TimeUnit;

/**
 * @author gongchengship@163.com
 * 直接 new 的都是强引用, 软弱虚引用都有其类名,
 * 垃圾回收器只有在没有强引用指向该对象时,才会回收该对象
 */
public class A_StrongReference {
    public static void main(String[] args) throws Throwable {
        M m = new M(); //直接 new 的都是强引用,垃圾回收器只有在没有强引用指向该对象时,才会回收该对象
        // 直接调用它不会起任何作用
        m.finalize(); // Object 中的finalize() 方法,其方法体中是没有代码的,即它本来什么也不做,它只是个模板方法,可以被子类覆盖,例如输出标记信息,资源回收等
        Thread.sleep(500);
        System.out.println("m = " + m);

        System.gc(); //调用垃圾回收器,但强引用不会被回收,因此不会调用到 m.finalize() 方法,不会打印 "finalize ..."
        Thread.sleep(500);
        System.out.println("m = " + m); //强引用不会被回收

        m = null; // 然后 m 有机会被 GC 回收
        TimeUnit.SECONDS.sleep(1);

        ////
        //分配一个占 10M 内存的Byte数组
        // 同时 JVM 自己会一直占据 heap 4M ~ 5M 内存
        Byte[] byteArray10M = new Byte[1024 * 1024 * 12];

        //再分配一个占 12M 内存的Byte数组, heap 将装不下,此时 JVM 会先 GC 一次, 发现不够
        //由于 java -Xmx20M 所以,堆空间不够,所以会抛出 OutOfMemoryError 异常
//        Byte[] byteArray12M = new Byte[1024 * 1024 *2]; // 触发 OOM 异常
        Thread.sleep(500);
        System.out.println("byteArray10M = " + byteArray10M);
//        System.out.println("byteArray12M = " + byteArray12M);

//        m = null; //会导致 原来指向 堆内存中的new Object() 对象的引用 obj 指向另一个地方(该地址是 null),所以没有强引用指向 new Object() 对象,垃圾回收器就会回收该对象
//        System.gc(); //没有强引用指向它了,会被回收
//        Thread.sleep(500);
//        System.out.println("m = " + m); //如果打印 null 说明堆内存中的 m 对象已经被回收了.
        TimeUnit.MINUTES.sleep(1); // 使用 visualvm 等监测工具时,防止程序退出
    }

}
