package com.example.a_abserver_or_pub_sub;

import java.util.Observable;
import java.util.Observer;

/**
 * @author gongchengship@163.com
 */
public class Worker implements Observer {

    private String name;

    private Observable observable;

    /**
     * 这个方法用于本 Subscriber 订阅 Subject
     * @param name 这是一个可又可无的标识
     * @param observable 主题
     */
    public Worker(String name, Observable observable) {
        this.name = name;
        this.observable = observable;
    }
    /**
     * This method is called whenever the observed object is changed.
     * 每当被观察者变动时,这个方法就会被调用
     * An application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     * 应用程序调用 <tt>Observable 对象<tt>的 <code>notifyObservers<code> 方法(进而在其中调用Observer 的 update 方法,亦即本方法)，
     * 从而将更改通知对象的所有观察者。
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     *            method.
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("老板在大门口说:" + arg.toString() + "我不能继续打游戏了");
    }
}
