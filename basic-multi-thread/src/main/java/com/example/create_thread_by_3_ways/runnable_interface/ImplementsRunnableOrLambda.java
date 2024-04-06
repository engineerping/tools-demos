package com.example.create_thread_by_3_ways.runnable_interface;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * 当一个线程创建了另一个线程时，创建线程的这个线程就被称为父线程（或父进程），而被创建的线程则被称为子线程。父线程和子线程之间的关系如下：
 *
 * 创建关系：父线程通过Thread类的构造函数或Executor框架创建子线程。
 * 生命周期：父线程通常会在子线程启动后继续执行，而子线程的生命周期可以独立于父线程。子线程可以在父线程结束后继续执行，也可以在父线程执行完毕前结束。
 * 资源共享：父线程和子线程可以共享同一进程的资源，如内存空间、文件句柄等。但是，每个线程都有自己的线程栈和程序计数器。
 * 同步：父线程和子线程之间可能需要进行同步，以避免竞态条件和确保数据一致性。Java提供了多种同步机制，如synchronized关键字、Lock接口、Semaphore等。
 * 等待子线程完成：父线程可以使用join方法等待子线程完成执行。这确保了在父线程继续执行之前，子线程已经运行结束。
 */
public class ImplementsRunnableOrLambda {
    public static void main(String[] args) {

        //implements Runnable
        Thread thread2_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // run() 方法: 1.不能声明抛出异常; 2.无返回值
                // 如果像下面一样抛出了非检查异常, 会导致本线程自己退出,不会影响 调用本线程的start方法创建当前线程的那个线程, 即父线程
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new ArrayList<>(0).get(1); // mocking throw index out of bound exception
                System.out.println("Implement Runnable to create thread...");
            }
        });


        //by lambda
        Thread thread2_2 = new Thread(
            () -> {
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Use lambda to simplify the action of implementing runnable to create threads");
            }
        );

        /**
         * 当一个线程创建了另一个线程时，创建线程的这个线程就被称为父线程（或父进程），而被创建的线程则被称为子线程。父线程和子线程之间的关系如下：
         *
         * 创建关系：父线程通过Thread类的构造函数或Executor框架创建子线程。
         * 生命周期：父线程通常会在子线程启动后继续执行，而子线程的生命周期可以独立于父线程。子线程可以在父线程结束后继续执行，也可以在父线程执行完毕前结束。
         * 资源共享：父线程和子线程可以共享同一进程的资源，如内存空间、文件句柄等。但是，每个线程都有自己的线程栈和程序计数器。
         * 同步：父线程和子线程之间可能需要进行同步，以避免竞态条件和确保数据一致性。Java提供了多种同步机制，如synchronized关键字、Lock接口、Semaphore等。
         * 等待子线程完成：父线程可以使用join方法等待子线程完成执行。这确保了在父线程继续执行之前，子线程已经运行结束。
         */
        thread2_1.start();

        /**
         * 父线程 的 其中一个子线程 抛出异常, 天然地不会影响兄弟线程.
         */
        thread2_2.start();
    }

}
