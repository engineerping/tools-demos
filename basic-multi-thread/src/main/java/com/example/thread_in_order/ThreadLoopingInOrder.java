package com.example.thread_in_order;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gongchengship@163.com
 * 三个线程，A线程打印A，B线程打印B，C线程打印C，要求启动后顺序打印ABCABCAB...
 */

public class ThreadLoopingInOrder {
    private static final int PRINT_COUNT = 8; // 题目设置打印 ABCABCAB, 故这里循环次数定为 8
    private static Lock reentrantLock = new ReentrantLock(); //在 try 块之前 初始化 reentrantLock
    private static Condition conditionA = reentrantLock.newCondition();
    private static Condition conditionB = reentrantLock.newCondition();
    private static Condition conditionC = reentrantLock.newCondition();
    private static volatile int state = 0; // 控制打印状态, 使用 volatile 以保证可见性

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintThread('A', 0));
        Thread threadB = new Thread(new PrintThread('B', 1));
        Thread threadC = new Thread(new PrintThread('C', 2));
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class PrintThread implements Runnable {
        private char printChar;
        private int threadState;

        public PrintThread(char printChar, int threadState) {
            this.printChar = printChar;
            this.threadState = threadState;
        }

        @Override
        public void run() {
            for (int i = 0; i < PRINT_COUNT; i++) {
                try {
                    reentrantLock.lock(); //在 try 块内应用reentrantLook 加锁, 然后只有某一个线程能持有锁可以执行下面的代码 ------ 锁被释放后,会有其他线程抢占到锁,然后执行 这一步获取锁的 代码.
                    while (state % 3 != threadState) { // state 初始为 0, 就意味着 如果 持有锁的线程的 threadState 不为 0 (假设 threadState 为 2),则程序走入该 while 循环体,条件不满足, 则 一直循环 等待自己的打印状态
                        if (printChar == 'A') {
                            conditionA.await();
                        } else if (printChar == 'B') {
                            conditionB.await();
                        } else if (printChar == 'C') { // threadState 为 2 时,持有锁的线程 被放入条件对象 conditionC 的等待队列,同时当前线程释放该 reentrantLock, 其他线程可以开始抢占 该 reentrantLock
                            conditionC.await();
                        }
                    }
                    // 条件满足了, 才 执行 打印 .
                    System.out.print(printChar);
                    state++; // 更新打印状态

                    // 选择一个目标线程唤醒操作 开始
                    if (printChar == 'A') {
                        conditionB.signal(); // 唤醒B线程
                    } else if (printChar == 'B') {
                        conditionC.signal(); // 唤醒C线程
                    } else if (printChar == 'C') {
                        conditionA.signal(); // 唤醒A线程
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock(); //在 finally 块中释放 reentrantLock
                }
            }
        }
    }
}
