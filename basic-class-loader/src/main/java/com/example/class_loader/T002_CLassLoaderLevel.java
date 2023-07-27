package com.example.class_loader;

public class T002_CLassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        //jdk 11中没有这个类了
        //System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T002_CLassLoaderLevel.class.getClassLoader());

        System.out.println(T002_CLassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
