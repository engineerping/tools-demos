package com.example.understandingjvm;

import java.io.IOException;
import java.io.InputStream;

public class DifferentClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name); //super 是父加载器,定义在ClassLoader类内,是pubic final的
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length); //调用native 方法去定义一个类
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        try {
            //因为myLoader 在加载一个之前已经被sun.misc.Launcher$AppClassLoader所加
            // 载过的类org.jacky.understandingjvm.DifferentClassLoaderTest
            Object obj = myLoader.loadClass("com.example.understandingjvm.DifferentClassLoaderTest").newInstance();
            System.out.println(obj.getClass());
            System.out.println(obj instanceof DifferentClassLoaderTest);
            //答案在下面这两句
            System.out.println(obj.getClass().getClassLoader());
            System.out.println(DifferentClassLoaderTest.class.getClassLoader());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
