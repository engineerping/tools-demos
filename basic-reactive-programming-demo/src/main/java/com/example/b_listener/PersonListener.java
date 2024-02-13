package com.example.b_listener;

/**
 * 事件监听器 (XxxListener)
 *
 * 用于监听 Person 事件源的 eat 和 sleep 方法
 *
 * @author gongchengship@163.com
 */
public interface PersonListener {

    void doEat(Event event);
    void doSleep(Event event);
}
