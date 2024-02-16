package com.example.wait_notify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 参考廖雪峰的官方网站
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580911915042#0
 * 1.当一个线程执行到getTask()方法内部的while循环时，它必定已经获取到了this锁，此时，线程执行while条件判断，如果条件成立（队列为空），线程将执行this.wait()，进入等待状态。
 * 这里的关键是：wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()。
 * 调用wait()方法后，线程进入等待状态，wait()方法不会返回，直到将来某个时刻，线程从等待状态被其他线程唤醒后，wait()方法才会返回，然后，继续执行下一条语句。
 * 有些仔细的童鞋会指出：即使线程在getTask()内部等待，其他线程如果拿不到this锁，照样无法执行addTask()，肿么办？
 * 这个问题的关键就在于wait()方法的执行机制非常复杂。首先，它不是一个普通的Java方法，而是定义在Object类的一个native方法，也就是由JVM的C代码实现的。
 * 其次，必须在synchronized块中才能调用wait()方法，因为wait()方法调用时，会释放线程获得的锁，wait()方法返回后，线程又会重新试图获得锁。
 * 因此，只能在锁对象上调用wait()方法。因为在getTask()中，我们获得了this锁，因此，只能在this对象上调用wait()方法：
 *
 * 2.当一个线程在this.wait()等待时，它就会释放this锁，从而使得其他线程能够在addTask()方法获得this锁。
 * 现在我们面临第二个问题：如何让等待的线程被重新唤醒，然后从wait()方法返回？答案是在相同的锁对象上调用notify()方法。我们修改addTask()如下：
 *
 * @author gongchengship@163.com
 */
public class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    /**
     * 1.当一个线程执行到getTask()方法内部的while循环时，它必定已经获取到了this锁，此时，线程执行while条件判断，如果条件成立（队列为空），
     * 线程将执行this.wait()，进入等待状态。
     *
     * 这里的关键是：wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()。
     *
     * 调用wait()方法后，线程进入 "等待状态(即进入等待队列--我标注)"，wait()方法不会返回，直到将来某个时刻，线程从等待状态被其他线程唤醒后，wait()方法才会返回，然后，继续执行下一条语句。
     *
     * 有些仔细的童鞋会指出：即使线程在getTask()内部等待，其他线程如果拿不到this锁，照样无法执行addTask()，肿么办？
     * 这个问题的关键就在于wait()方法的执行机制非常复杂。
     * 首先，它不是一个普通的Java方法，而是定义在Object类的一个native方法, 也就是由JVM的C代码实现的。(它运行了操作系统 "管程" 的思想)
     *
     * 其次，必须在synchronized块中才能调用wait()方法，因为wait()方法调用时，会释放线程获得的锁，wait()方法返回后, 后面的业务代码开始执行，则线程又会重新试图获得锁。
     * 因此，只能在锁对象(本例中是this)上调用wait()方法。因为在getTask()中，我们获得了this锁，因此，只能在this对象上调用wait()方法：
     * @return
     * @throws InterruptedException
     */
    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            //!!! native 的 wait方法会释放 this 锁 !!!
            this.wait(); //这里的关键是：wait()方法必须在当前获取的锁对象上调用，这里获取的是this锁，因此调用this.wait()。
            //!!! native 的 wait方法会重新获取 this 锁 !!!
        }
        return queue.remove();
    }


    /**
     * 2.当一个线程在this.wait()等待时，它就会释放this锁，从而使得其他线程能够在addTask()方法获得this锁。
     * 现在我们面临第二个问题：如何让等待的线程被重新唤醒，然后从wait()方法返回？
     * 答案是在相同的锁对象上调用notify()方法。我们修改addTask()如下：
     * @param s
     */
    public synchronized void addTask(String s) {
        this.queue.add(s);
        /*
        这个例子中，我们重点关注addTask()方法，内部调用了this.notifyAll()而不是this.notify()，
        使用notifyAll()将唤醒所有当前正在this锁等待的线程，而notify()只会唤醒其中一个（具体哪个依赖操作系统，有一定的随机性）。
        这是因为可能有多个线程正在getTask()方法内部的wait()中等待，使用notifyAll()将一次性全部唤醒。通常来说，notifyAll()更安全。
        有些时候，如果我们的代码逻辑考虑不周，用notify()会导致只唤醒了一个线程，而其他线程可能永远等待下去醒不过来了。

        但是，注意到wait()方法返回时需要重新获得this锁。假设当前有3个线程被唤醒，唤醒后，首先要等待执行addTask()的线程结束此方法后，
        才能释放this锁，随后，这3个线程中只能有一个获取到this锁，剩下两个将继续等待。
         */
        this.notifyAll(); //唤醒在 this 锁等待的所有线程,但是只有一个线程能抢到锁,其他线程继续等待,在本例中作用同 notify().
    }

}
