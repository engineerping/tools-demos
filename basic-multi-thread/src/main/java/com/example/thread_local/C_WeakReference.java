package com.example.thread_local;

import java.lang.ref.WeakReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @author gongchengship@163.com
 *
 * 结论: 弱引用只要的对象只要 GC 发生,就会被回收,
 * 弱引用的应用是在 ThreadLocal 中, 当然一个对象同时被同时被一个强引用和一个弱引用指向(是为了像强引用一样能访问到对象),
 * 一旦强引用消失,那么接下来一旦 GC 发生, 该对象就会被回收,即 弱引用 不会被 GC 无视.
 * 即: "能像强引用工一样帮助访问对象,但有能方便 GC 回收" 这就是WeakReference 的用途.
 *
 * 注意本例运行要设置 JVM 最大堆内存 -Xmx20; 如果 IDEA 不容易设置,可以使用如下命令,注意要 cd 到 com 所在的目录
 * javac ./com/example/thread_local/B_WeakReference.java;
 * java -Xmx20M -cp . com.example.thread_local.B_WeakReference;
 */
public class C_WeakReference {
    public static void main(String[] args) throws InterruptedException {
        //千万注意 wr 是"强引用"指向堆中的 WeakReference()对象. new关键字直接 new 出来的对象都是 "强引用".
        // *WeakReference 类的意思是说 WeakReference 的 Constructor 参数赋值给WeakReference的成员变量,该成员变量指向堆内对象是弱引用(jdk注释写的很清楚)*
        //换句话说,弱引用是指 WeakReference 的对象内部 "WeakReference#referent变量" 指向 "new byte[1024 * 1024 *10](这是一个占 10M内存的 Byte数组对象)", 这个 指向关系 是弱引用
        WeakReference<byte[]> wr = new WeakReference(new byte[1024 * 1024 *10]); //千万注意 wr 是"强引用"指向堆中的WeakReference()对象.

        ////
        System.out.println("wr = " + wr.get()); //有可能获取到也有可能是 null; 创建后立即 获取那个 10M 的Byte数组, 在 GC 不频繁的情况下,可以获取到;
        System.gc();
        Thread.sleep(1000);
        System.out.println("wr = " + wr.get());//null;  弱引用一旦 JVM 有 GC 发生, 就会被回收.

        ////
        //再分配一个占 12M 内存的Byte数组, heap 将装不下,此时 JVM 会先 GC 一次, 此时弱引用就会被回收掉
        //由于 java -Xmx20M 所以,堆空间不够,GC 就就会回收掉 WeakReference#referent 软 引用指向的对象
        Byte[] byteArray = new Byte[1024 * 1024 *12];
        Thread.sleep(1000);
        System.out.println("wr = " + wr.get()); //null; 此时就 弱引用的对象就被回收了, 所以 wr.get()返回 null

        ////
        //总结:
        // WeakReference#referent 变量指向的对象在 JVM 发生 GC 时, 会被直接回收掉
        // "能像强引用工一样帮助访问对象,但有能方便 GC 回收",

        ////
        //用途: 见ThreadLocal

        TimeUnit.MINUTES.sleep(1);
    }




}
