package com.example.designpattern.double_check_lock_singleton;

/**
 * @author gongchengship@163.com
 * 双重检查锁单例的好处:
 * 1. 多线依然可以保证单例
 * 2. 性能无损失
 * 3. 懒汉模式
 *
 * ref: https://hyrepo.com/tech/double-check-lock/
 */
public class DCL_Singleton {
    /*
     1. 加 volatile 是为了阻止 [指令重排序] 优化!
     2.如果没有加 volatile 会发生什么呢?
     -->
        2.1.new DCL_Singleton(), 这条语句, 实际上可以分解成以下三个步骤：
            2.1.1.分配内存空间
            2.1.2.初始化对象
            2.1.3.将对象指向刚分配的内存空间
        2.2.不有加 volatile 的情况下, 2.1.3 可能会由于 CPU 的优化结果, 导致 2.1.3 在 2.1.2 之前执行.

        现在考虑重排序后，两个线程发生了以下调用：
        ------
        Time	Thread A	                            Thread B
        T1	检查到uniqueSingleton为空
        T2	获取锁
        T3	再次检查到uniqueSingleton为空
        T4	为uniqueSingleton分配内存空间
        T5	将uniqueSingleton指向内存空间
        T6		                                    	检查到uniqueSingleton不为空
        T7		                                    	访问uniqueSingleton（此时对象还未完成初始化）
        T8	初始化uniqueSingleton

        ------

        2.3.这种情况下，T7 时刻 线程B对 uniqueSingleton 的访问，访问的是一个 [初始化未完成的对象], 所以加入 volatile 1️以阻止指令重排序优化 。
     */
    private volatile static DCL_Singleton uniqueSingleton;

    private DCL_Singleton() {
    }

    public DCL_Singleton getInstance() {
        if (null == uniqueSingleton) {  // 第一次 if 检查, 如果实例已存在则 不进入 if 块,直接返回,
            synchronized (DCL_Singleton.class) { // synchronized 加在 第一次检查 的 if快 里面 而 不是外面, 是为了 避免第一次检查时 读取操作的性能损失.
                if (null == uniqueSingleton) { // 第二次 if 检查, 比较常规, 是为了检查对象是否已被 实例化.
                    uniqueSingleton = new DCL_Singleton();
                }
            }
        }

        return uniqueSingleton;

    }

}
