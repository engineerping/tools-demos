package com.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author gongchengship@163.com
 *
 * 当需要实现一个函数是接口中的那个唯一方法时,
 * 正好有一个传统类的 "非-静态" 方法的"方法体"可以充当该接口的实现 (注意这里要强调下若从方法签名的角度看其实是不可以充当的) 时,
 * 那么为了简化 lamda 表达是的写法, 就可以使用实例 "方法 '引' 用" (注意是"方法引用", 而不是"方法调用") 了.
 *
 * (本例只实践最不容易理解的调用 传统类的 "非-静态" 的部分, 完整内容见:https://zhuanlan.zhihu.com/p/266804576)
 *
 * 那么其规则是这样的:
 */
public class MethodCallTest {

    public static void main(String[] args) {
        MethodCallTest mc = new MethodCallTest();
        mc.test1();
        mc.test2();
    }

    /**
     * 将要被调用的 传统类的实例方法
     */
    public void print(String s){
        System.out.println(s);
    }

    /**
     * 引用特定对象实例方法
     */
    public void test1(){
        List<String> list = Arrays.asList("a","b","c");
        //实例方法引用  instanceRef::methodName
        list.forEach(new MethodCallTest()::print);
        //上一行等价于
        //list.forEach((x)->new Colon().print(x));
    }

    /**
     * 引用特定类型的任意对象的实例方法
     */
    public void test2(){
        String[] arr = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        //引用String类型的任意对象的compareToIgnoreCase方法实现忽略大小写排序
        Arrays.sort(arr, String::compareToIgnoreCase);
        //上一行等价于
        //Arrays.sort(arr, (a,b)->a.compareToIgnoreCase(b));
        //输出
        for(String s:arr){
            System.out.println(s);
        }
    }
}
