package com.example.dynamic_proxy.jdk;

public class TestWIthJDKProxy {
    public static void main(String[] args) {
        //这句话是为了让JDK所生成的class文件被保存下来，让程序员可读。
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //重点:程序员需要手动new 代理对象。
        Calculator cal = (Calculator) new LoggerProxy<Calculator>(new CalculatorImpl()).getProxyInstance();
        cal.add(1, 2);
    }
}
