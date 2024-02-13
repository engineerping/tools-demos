package com.example.b_listener;

/**
 * 事件对象 Event
 *
 * 事件对象封装了 事件源(Person)
 *
 * 在监听器上呢能够通过 事件对象(Event) 获取到 事件源(Person)
 *
 * @author gongchengship@163.com
 */
public class Event {
    private Person person;

    public Event() {

    }

    public Event(Person person) {
        this.person = person;
    }

    public Person getResource() {
        return person;
    }
}
