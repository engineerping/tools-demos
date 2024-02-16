package com.example.wait_notify;

import java.util.ArrayList;
import java.util.List;

/**
 * 参考廖雪峰的官方网站
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1306580911915042#0
 *
 * @author gongchengship@163.com
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue queue = new TaskQueue();
        List<Thread> gettingThreadList = new ArrayList<>();
        /*
        创建 5 个线程,
        每个线程中都是死循环地尝试,一旦 queue 中有元素,就会有一个线程成功地抢到锁,从 queue 取出元素
         */
        for (int i = 0; i < 5; i++) {
            /*
            线程的 run 方法是在 未来, 当线程被 start 之后, 然后在获得 CPU 执行权限后才开始执行的方法.
            所以 for 只要在 thread.start() 方法执行之前 给 thread.setName() 那么就是有效的.如 For 循环循环体之后的第一行代码.
            */
            Thread gettingThread = new Thread(() -> {
                // 执行 task
                while (true) {
                    String str = null;
                    try {
                        str = queue.getTask();
                        System.out.println(Thread.currentThread().getName() + "从 queue 中取出元素: " + str);
                    } catch (InterruptedException e) {
                        return; //TODO: 为什么这里 catch 到异常后,忽略了异常?
                    }
                }
            });
            gettingThread.setName("名称为 " + (i + 1) + " 的 gettingThread 线程");
            gettingThread.start();
            gettingThreadList.add(gettingThread); //将线程的引用存储到一个 List 中
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////

        /*
        创建一个线程,往 queue 中添加 10 个元素,
        但 addTask()方法中, 每向 queue 中 add 一个元素,都会 notifyAll 通知其他 gettingThread 线程去 queue 中取出元素.
        */
        Thread addingThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //放入 task
                String s = "t-" + Math.random();
                System.out.println(Thread.currentThread().getName() + "向 queue 中添加元素: " + s);
                queue.addTask(s);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        addingThread.setName("唯一的 addingThread");
        addingThread.start();
        /* 参考: https://www.cnblogs.com/duanxz/p/5038471.html
        主线程等待子线程的终止。也就是说主线程的代码块中，如果碰到了t.join()方法，此时主线程需要等待（阻塞），
        等待子线程 t 执行结束了(Waits for this thread to die.),才能继续执行t.join()之后的代码块。
        */
        addingThread.join(); //TODO: 示例中为什么这里没有 try...catch, 而是 throw 了?
        Thread.sleep(100);

        for (Thread t : gettingThreadList) {
            t.interrupt(); //TODO: 不手动中断 那些 gettingThread 会怎么样? 这里手动中断是必须的吗?
        }
    }
}
