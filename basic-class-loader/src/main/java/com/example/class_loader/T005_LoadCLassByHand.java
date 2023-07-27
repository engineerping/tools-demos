package com.example.class_loader;

public class T005_LoadCLassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        //因为HotSpot使用的是懒加载机制,当类被用到的时候才去加载,所以类org.jacky.class_loader.T002_CLassLoaderLevel目前并没有被加载
        ClassLoader classLoader = T005_LoadCLassByHand.class.getClassLoader();
        System.out.println(classLoader.getClass().getName());
        Class clazz = classLoader.loadClass("com.example.class_loader.T002_CLassLoaderLevel");
        System.out.println(clazz.getName());
    }
}
