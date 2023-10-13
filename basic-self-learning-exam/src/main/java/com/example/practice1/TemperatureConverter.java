package com.example.practice1;

import java.util.Scanner;

/**
 * 写一个程序,将摄氏温度,转化为华氏温度,转换公式如下:
 * 华氏温度 = (9/5) * 摄氏温度 + 32
 */
public class TemperatureConverter {
    static double CONST_VALUE = 9.0 / 5;

    public static void main(String[] args) {
        scanDoubleFromKeyboard();
    }

    /**
     * Scan double vale from keyboard
     */
    public static void scanDoubleFromKeyboard() {
        System.out.println("请以 Double 格式输入摄氏温度:");
        Scanner scanner = new Scanner(System.in);
        double doubleInput = 0D;
        while(scanner.hasNextLine()) {
            if (scanner.hasNextDouble() == false) {
                System.out.println("输入内容不是 Double 格式, 重新开始");
                scanDoubleFromKeyboard(); //递归调用,这里不进入该递归的条件是 scanner.hasNextDouble() == true;
            }
            doubleInput = scanner.nextDouble();
            ////business start
            double ht = converter(doubleInput);
            ////business end
            System.out.println("您输入的摄氏温度是 " + doubleInput + " , 对应的华氏温度是: " + ht);
        }
        scanner.close();
    }
    public static double converter(double st) {
        return CONST_VALUE * st + 32;
    }
}
