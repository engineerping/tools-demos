package com.example.dynamic_proxy.jdk;

public class CalculatorImpl_test {

    public static void main(String[] args) {
        //1. 创建原始类(被代理类)的实例
        Calculator target = new CalculatorImpl();
        //2. 实现InvocationHandler接口
        //  2.1 实现其中的invoke模板方法,以阐明具体如何增强原始类
        LoggerProxy<Calculator> handler = new LoggerProxy<>(target);
        //3. 获取JDK生成的代理对象
        Calculator calculatorProxy = handler.getProxyInstance();
        //4. 调用代理类的方法
        calculatorProxy.add(1, 2);
    }
}
