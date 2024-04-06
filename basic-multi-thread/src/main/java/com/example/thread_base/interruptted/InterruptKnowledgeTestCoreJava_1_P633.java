package com.example.thread_base.interruptted;

/**
 * <p>TIPS: Character set of current file is "UTF-8",just in case of Chinese characters displays in garbled</p>
 * 描述:
 * <p>
 * 优雅地停止一个线程，要用死循环:
 * interrupt() 方法用于将线程的断标志位的值设置为true,线程每运行一步，都会主动去检查这个中断标志位的值。
 * isInterrupted() 方法用于读取线程的中断标志位的值,然后程序员根据自己的需要写自己的逻辑。
 * static interrupted 用于读取线程的中断标志位的值，并将其设置为默认值false（重置）。
 * </p>
 * <p>
 * InterruptedException知识点：一下 3 中方法会让线程暂停工作，
 * sleep(long) 休眠
 * wait()/wait(long)：等待被notify()/notifyAll() 唤醒
 * join()/jone(long) 等待另一个线程执行完
 * 当这 3 种方法正在运行期间，对其所在线程调用Thread.currentThread().isInterrupted()方法检查中断标志位时，
 * 会抛出InterruptedException。
 * 原因是线程在运行这 3 中方法时，处于暂停过工作的状态,无法运行任何其他方法，当然业就无法运行isInterrupted()检查中断标志位，
 * 所以就会抛出InterruptedException。
 * </p>
 */
public class InterruptKnowledgeTestCoreJava_1_P633 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) { //isInterrupted() 方法用于读取线程的中断标志位的值,然后程序员根据自己的需要写自己的逻辑。
//            while (!Thread.interrupted()) { //static interrupted 用于读取线程的中断标志位的值，并将其设置为默认值false（重置）。
//            while (true) {
                try {
                    System.out.println("Hi, This is in sub thread..." + i++);
                    System.out.println("1 Is current thread interrupted: " + Thread.currentThread().isInterrupted());
                    Thread.sleep(2000);
                    System.out.println("2 Is current thread interrupted: " + Thread.currentThread().isInterrupted());
//
//                    if (i == 5) {
//                        Thread.currentThread().interrupt();
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //thread was interrupted during sleep or wait
                } finally {
                    //cleanup, if necessary
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
        Thread.sleep(500);
        t.interrupt(); //设置线程的中断标志位为true
        System.out.println("3 Is current thread interrupted: " + t.isInterrupted());
    }
}
