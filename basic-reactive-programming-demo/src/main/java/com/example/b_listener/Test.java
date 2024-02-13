package com.example.b_listener;

/**
 * 监听器就是一个实现特定接口的普通java程序，这个程序专门用于监听另一个java对象的方法调用或属性改变，当被监听对象发生上述事件后，监听器某个方法将立即被执行.
 *
 *
 * @author gongchengship@163.com
 */
public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.registerListener(new PersonListener() {
            @Override
            public void doEat(Event event) {
                System.out.println("监听到" + event.getResource() + "正在吃饭...");
            }

            @Override
            public void doSleep(Event event) {
                System.out.println("监听到" + event.getResource() + "睡着了~~~");
            }
        });

        // 调用事件源的 业务方法
        person.eat();
    }
}
