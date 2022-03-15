package com.example.reflection;

import java.lang.annotation.ElementType;

public class ClassTest {
    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;
        Class<Comparable> interfaceClass = Comparable.class;
        Class<ElementType> enumerationClass = ElementType.class;
        Class<Override> annotationClass = Override.class;
        Class<Integer> basicDataClass = int.class;
        Class<Integer> wrappedDataClass = Integer.class;
        Class<double[]> basicDataArrayClass = double[].class;
        Class<String[]> arrayClass = String[].class;
        Class<String[][]> binArrayClass = String[][].class;
        Class<Class> clazz = Class.class;
        Class<Void> typeClass = void.class;

        System.out.println(objectClass);
        System.out.println(enumerationClass);
        System.out.println(annotationClass);
        System.out.println(basicDataClass);
        System.out.println(wrappedDataClass);
        System.out.println(basicDataArrayClass);
        System.out.println(arrayClass);
        System.out.println(binArrayClass);
        System.out.println(clazz);
        System.out.println(typeClass);

        /**
         运行结果:
         class java.lang.Object
         class java.lang.annotation.ElementType
         interface java.lang.Override
         int
         class java.lang.Integer
         class [D       //[D 表示一维 Double数组
         class [Ljava.lang.String; //[L 表示一维String数组
         class [[Ljava.lang.String; //[[L 表示二维String数组
         class java.lang.Class
         void
         */



    }
}
