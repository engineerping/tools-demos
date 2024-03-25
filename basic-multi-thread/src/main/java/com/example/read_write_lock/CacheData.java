package com.example.read_write_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author gongchengship@163.com
 * 参考: https://cloud.tencent.com/developer/article/2322796
 *     public interface ReadWriteLock {
 *         // 读锁
 *         Lock readLock();
 *             // 写锁
 *         Lock writeLock();
 *     }
 *     可见读写锁其实就是维护了一对锁，一个写锁一个读锁，通过读写分离的策略，允许多个线程同时获取读锁，大大提高并发性。
 *
 * //////
 * 参考: https://www.cnblogs.com/mikechenshare/p/16743733.html
 * 读写锁的特点 -->
 * 公平性：读写锁支持非公平和公平的锁获取方式，非公平锁的吞吐量优于公平锁的吞吐量，默认构造的是非公平锁
 * 可重入：在线程获取读锁之后能够再次获取读锁，但是不能获取写锁，而线程在获取写锁之后能够再次获取写锁，同时也能获取读锁
 * 锁降级：线程获取写锁之后获取读锁，再释放写锁，这样实现了写锁变为读锁，也叫锁降级
 *
 * 锁降级的必要性 -->
 * 降级是指当前把持住写锁，再获取到读锁，随后释放(先前拥有的)写锁的过程。
 *
 * 锁降级过程中的读锁的获取是否有必要，答案是必要的。主要是为了保证数据的可见性，
 * 如果当前线程不获取读锁而直接释放写锁，假设此刻另一个线程获取的写锁，并修改了数据，
 * 那么当前线程就步伐感知到线程T的数据更新，如果当前线程遵循锁降级的步骤，那么线程T将会被阻塞，
 * 直到当前线程使数据并释放读锁之后，线程T才能获取写锁进行数据更新。
 *
 * //////
 * 读写锁的使用
 * 参考: https://juejin.cn/post/7154295629148061726
 */
public class CacheData {
    Object data;

    //标识缓存是否有效,默认为false
    // 注意：这里使用volatile修饰，保证一个线程修改了 cacheValid 变量,
    // 变量只会立即写入主内存, 其他线程能够立即可见性.
    volatile boolean cacheValid;

    // 创建读写锁实例
    final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    void processCachedData() {
        //获取读锁
        rwLock.readLock().lock(); // 将在 line38 处释放
        // 如果缓存是无效的, 则获取写锁, 准备更新缓存,即向缓存中写入新数据.
        if (!cacheValid) {

            // 现在就可以释放读锁了, 释放后其他线程可以获得读锁
            rwLock.readLock().unlock(); //释放 line33 的读锁

            // 获取 "写锁"
            rwLock.writeLock().lock(); // 将在 line57 处释放

            try {

                // 重新检查缓存是否有效的 标志位, 因为在等待写锁的过程中, 其他线程可能已经更新了缓存数据
                if (!cacheValid) {
                    //向缓存中写入新数据
                    data = new String("a_new_data");
                    // 让缓存有效, 且立即让其他线程知道
                    cacheValid = true;
                }
                /**
                 * ReentrantReadWriteLock读写锁分为读锁和写锁，读锁是共享锁，写锁是独占锁。
                 *
                 * 4.锁降级 -->
                 *  锁降级过程中的读锁的获取是否有必要，答案是必要的。主要是为了保证数据的可见性，
                 *  如果当前线程不获取读锁而直接释放写锁，假设此刻另一个线程获取的写锁，并修改了数据，
                 *  那么当前线程就步伐感知到线程T的数据更新，如果当前线程遵循锁降级的步骤，那么线程T将会被阻塞，
                 *  直到当前线程使数据并释放读锁之后，线程T才能获取写锁进行数据更新。
                 *
                 *
                 */
                rwLock.readLock().lock(); // 将在 line69 处释放. 加锁的代码块要尽量少,以提高代码性能

            } finally {
                // 在 finally 块中释放写锁 , 此时还剩一个读锁 未释放
                rwLock.writeLock().unlock(); // 释放 line41 的写锁
            }
        }

        try {
            // 使用数据
            System.out.println(data);
        } finally {
            // 在 finally 块中 释放读锁
            rwLock.readLock().unlock(); // 释放 line56 的读锁
        }

    }
}
