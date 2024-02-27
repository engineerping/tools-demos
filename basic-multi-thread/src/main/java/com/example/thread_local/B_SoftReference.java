package com.example.thread_local;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @author gongchengship@163.com
 *
 * 结论: 内存足够就不会被回收,内存不够了才会GC被回收
 *
 * 注意本例运行要设置 JVM 最大堆内存 -Xmx20; 如果 IDEA 不容易设置,可以使用如下命令,注意要 cd 到 com 所在的目录
 * javac ./com/example/thread_local/B_SoftReference.java;
 * java -Xmx20M -cp . com.example.thread_local.B_SoftReference;
 */
public class B_SoftReference {
    public static void main(String[] args) throws InterruptedException {
        //千万注意 sr 是"强引用"指向堆中的softReference()对象. new关键字直接 new 出来的对象都是 "强引用".
        // *SoftReference 类的意思是说 SoftReference 的 Constructor 参数赋值给SoftReference的成员变量,该成员变量指向堆内对象是弱引用(jdk注释写的很清楚)*
        //换句话说,软引用是指 SoftReference 的对象内部 "SoftReference#referent变量" 指向 "new byte[1024 * 1024 *10](这是一个占 10M内存的 Byte数组对象)", 这个 指向关系 是弱引用
        SoftReference<byte[]> sr = new SoftReference(new byte[1024 * 1024 *10]); //千万注意 sr 是"强引用"指向堆中的softReference()对象.

        ////
        System.out.println("sr = " + sr.get()); //获取那个 10M 的Byte数组, 并打印
        System.gc();
        Thread.sleep(1000);
        System.out.println("sr = " +sr.get());// 软引用在堆内存空间足够时,就不会被回收.

        ////
        //再分配一个占 12M 内存的Byte数组, heap 将装不下,此时 JVM 会先 GC 一次, 发现不够,会把软引用指向的对象回收掉
        //由于 java -Xmx20M 所以,堆空间不够,就会回收掉 SoftReference#referent 软 引用指向的对象
        Byte[] byteArray = new Byte[1024 * 1024 *5];
        Thread.sleep(1000);
        System.out.println("sr = " +sr.get()); //此时就 弱引用的对象就被回收了, 所以 sr.get()返回 null

        ////
        //总结:
        // 在内存空间足够时, SoftReference#referent变量指向的对象不会被回收,
        // 但当堆空间不够时,就会回收掉 SoftReference#referent变量指向的对象
        // 避免了内存不足时 直接 OOM

        ////
        //用途: 缓存

        TimeUnit.MINUTES.sleep(60);
    }




}
