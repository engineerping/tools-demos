package com.example.volatileuseage;

public abstract class IntGenerator {
    /**
     * volatile的作用:
     * 1.保证线程可见性,
     * 2.防止指定重排序
     *
     * 用途：
     * 当对对变量的修改不依赖其原值时，可以用volatile，如true/false
     *
     */
    private volatile boolean canceled = false;
    public abstract int next();

    public void cancel() {
        this.canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
