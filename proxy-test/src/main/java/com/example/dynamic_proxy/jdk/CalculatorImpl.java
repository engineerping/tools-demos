package com.example.dynamic_proxy.jdk;

/**
 * 这是一个期望自己被JDK代理的类
 */
public class CalculatorImpl implements Calculator {
    //add , subtract , multiply and divide
    @Override
    public int add(int x, int y) {
        int result = x + y;
        System.out.println(result);
        return result;
    }

    public int subtract(int x, int y) {
        int result = x - y;
        System.out.println(result);
        return result;
    }
}
