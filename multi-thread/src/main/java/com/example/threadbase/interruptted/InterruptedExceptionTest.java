package com.example.threadbase.interruptted;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 *
 * InterruptedException知识点：一下 3 中方法会让线程暂停工作，
 * sleep(long) 休眠
 * wait()/wait(long)：等待被notify()/notifyAll() 唤醒
 * join()/jone(long) 等待另一个线程执行完
 * 当这 3 种方法正在运行期间，对其所在线程调用Thread.currentThread().isInterrupted()方法检查中断标志位时，
 * 会抛出InterruptedException。
 * 原因是线程在运行这 3 中方法时，处于暂停过工作的状态,无法运行任何其他方法，当然业就无法运行isInterrupted()检查中断标志位，
 * 所以就会抛出InterruptedException。
 *
 */
public class InterruptedExceptionTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread( () -> {

        });
    }
}
