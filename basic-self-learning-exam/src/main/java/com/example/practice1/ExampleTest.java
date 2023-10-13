package com.example.practice1;

/**
 * 推断个表达式的值,并上机运行比较与推断是否一致
 */
public class ExampleTest {
    public static void main(String[] args) {
        int no = (11 + 20) * 3 / 5; //判断输出为: 18;判断正确 [分析:手动计算结果为 18.6,推断仅会丢失精度,不会四舍五入, 四舍五入需要调用 Math.round()方法]
        System.out.println("no = " + no );

        Double myFloat = 1.5;
        System.out.println(Math.round(myFloat)); //四舍五入 Math.round()
        System.out.println(Math.ceil(myFloat)); //向上取整 Math.floor()
        System.out.println(Math.floor(myFloat)); //向下取整 Math.floor()

        ////
        no++; //判断输出为 19; 判断正确 [分析先参与运算,再自增,这里没有运算,直接自增]
        System.out.println("no = " + no );

        ////
        Boolean bool = false;
        bool = true & !bool;  //判断输出为 true [分析: 等号优先级最低]
        System.out.println("bool = " + bool );

        ////
        Byte bValue = 0x10; // 0x是十六进制, 0x10 是十进制 16;
        System.out.println("bValue = " + bValue ); //!!!注意, 结果为十进制输出 16 !!! 而不是 16 进制输出 0x10;
        bool = (no > bValue); //判断输出为 true [分析: no 为十进制 19, bValue 为十进制 16, 判断结果为 true]
        System.out.println("bool = " + bool );

    }
}
