package com.example;

public abstract class IntGenerator {
    //volatile的作用: 1.保证线程可见性,2.防止指定重排序
    private volatile boolean canceled = false;
    public abstract int next();

    public void cancel() {
        this.canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
