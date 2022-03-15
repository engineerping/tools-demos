package com.example.class_loader;

public class T001_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T {
    public static int count = 2; //链接阶段的准备阶段被赋值为 0
    public static T t = new T(); //链接阶段的准备阶段被赋值为 null

    private int number = 8;

    private T() {
        count++;
        System.out.println("--" + count);
    }
}
