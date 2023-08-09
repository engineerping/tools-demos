package com.example.dynamic_proxy.jdk;

public class TestWithoutJDKProxy {
    public static void main( String[] args ){
        Calculator cal = new CalculatorImpl();
        cal.add(1, 2);
    }
}
