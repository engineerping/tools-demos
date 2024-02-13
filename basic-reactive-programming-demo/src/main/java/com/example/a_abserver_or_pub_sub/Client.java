package com.example.a_abserver_or_pub_sub;

import java.util.Observer;

/**
 * <<大话设计模式>> page131:
 * "
 * 观察者模式又叫发布/订阅模式(Publish/Subscribe),
 * 观察者模式定义了一种一对多的依赖关系,让多个观察者(Observer/Subscriber)对象同时监听某一个主题(Subject/Publisher/Observable)对象,
 * 这个主题对象在状态发生变化(setChange)时,会通知(notifyObservers)所有的观察者对象,使它们能够自动更新(update)自己
 * "
 * 本例是 <<大话设计模式>> 最地道的 Java版实现
 *
 * @author gongchengship@163.com
 */
public class Client {
    public static void main(String[] args) {
        Boss boss = new Boss();
        Observer worker1 = new Worker("张三", boss); //Subscriber订阅Subject
        Observer worker2 = new Worker("李四", boss); //Subscriber订阅Subject

        boss.addObserver(worker1);
        boss.addObserver(worker2);
        boss.setChange(); //状态变化
        boss.notifyObservers("老板我又回来了!"); //发布通知
    }
}
