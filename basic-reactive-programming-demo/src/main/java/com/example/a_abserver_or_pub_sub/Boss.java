package com.example.a_abserver_or_pub_sub;

import java.util.Observable;

/**
 * Boss 类就是<<大话设计模式>> 中的 ConcreteSubject,
 * Observable 类就是 类就是<<大话设计模式>> 中的 Subject类
 *
 * @author gongchengship@163.com
 */
public class Boss extends Observable {

    public void setChange() {
        setChanged();
    }
}
