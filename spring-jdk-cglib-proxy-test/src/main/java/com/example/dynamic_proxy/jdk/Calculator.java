package com.example.dynamic_proxy.jdk;

/**
 * 类期望自己被JDK动态代理,就要实现接口
 */
public interface Calculator {
    int add(int x, int y); //默认是 public abstract
    int subtract(int x, int y);
}
