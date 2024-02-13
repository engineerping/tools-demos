package com.example.b_listener;

/**
 * 事件源(Resource) Person类
 *
 * 事件源要求提供方法,以注册监听器 (即在事件源上关联监听器对象)
 *
 * 如果触发了eat或sleep()方法的时候，会调用监听器的方法，并将事件对象传递进去
 * @author gongchengship@163.com
 */
public class Person {
    private PersonListener personListener;

    /**
     *在事件源中定义两个方法 eat
     */
    public void eat() {
        System.out.println("与 吃饭 相关的业务方法");

        //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
        personListener.doEat(new Event(this));
    }

    /**
     *在事件源中定义两个方法 sleep
     */
    public void sleep() {
        System.out.println("与 睡觉 相关的业务方法");

        //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
        personListener.doSleep(new Event(this));
    }

    /**
     *注册监听器，该类没有监听器对象啊，那么就传递进来吧。
     */
    public void registerListener(PersonListener personListener) {
        this.personListener = personListener;
    }
}
