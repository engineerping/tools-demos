package com.example.thread_local;

/**
 * @author gongchengship@163.com
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        // super.finalize(); 其实只是个模板方法,方法体为空,即什么也不做,其会实施在 gc 前被 jvm 调用一下
        System.out.println("finalizing ...");
    }
}
