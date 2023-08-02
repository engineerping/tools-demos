package com.example;


import java.io.*;
import java.io.FileInputStream;

public class SerializableDemo {

    public static void main(String[] args) throws Exception {
        SerializableDemo serializableDemo = new SerializableDemo();
//        serializableDemo.serializeTest();
        serializableDemo.deserializeTest();
    }

//    public void serializeTest() throws Exception{
//        File file = new File("person.out"); //会在src 同目录下生成person.out文件
//        //序列化
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//        Person person = new Person("小明",18, "上海");
//
//        objectOutputStream.writeObject(person);
//        objectOutputStream.close();
//    }

    public void deserializeTest() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.out"));
        Object newPerson = objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(newPerson);

    }


    //------------------------------------------------------------------------------------------------
    //测试一：
    // 1.仅修改Person 类中的 serialVersionUID 值，其他什么也不改
    // 2.依旧使用现存的 文件 basic-serializable-test/person.out,
    // ====>执行 deserializeTest 方法，失败。
    //
    // #可见 serialVersionUID的作用
    //
    // 输出
    // java.io.InvalidClassException: com.example.Person; local class incompatible: stream classdesc serialVersionUID = 1123456777,
    // local class serialVersionUID = 2
    //
    //	at java.io.ObjectStreamClass.initNonProxy(ObjectStreamClass.java:699)
    //	at java.io.ObjectInputStream.readNonProxyDesc(ObjectInputStream.java:2028)
    //	at java.io.ObjectInputStream.readClassDesc(ObjectInputStream.java:1875)
    //	at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:2209)
    //	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1692)
    //	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:508)
    //	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:466)
    //	at com.example.SerializableDemo.testDeserializeV1(SerializableDemo.java:25)
    //	at java.lang.reflect.Method.invoke(Method.java:498)
    //	at java.util.ArrayList.forEach(ArrayList.java:1259)
    //	at java.util.ArrayList.forEach(ArrayList.java:1259)
    //
    //------------------------------------------------------------------------------------------------




    //------------------------------------------------------------------------------------------------
    //测试二：
    // 1： 给 person 类加一个字段，email，
    // 2.依旧使用现存的 文件 basic-serializable-test/person.out,
    // 3.不给Person 类的 toString () 方法添加 email 信息，
    // ====>执行 deserializeTest 方法，成功，输出Person{name='小明', age=18, address='上海'}
    // 4.给Person 类的 toString () 方法添加 email 信息，
    // ====>执行 testDeserializeV1 方法，成功，输出Person{name='小明', age=18, address='上海', email='null'}
    //
    //------------------------------------------------------------------------------------------------



    //------------------------------------------------------------------------------------------------
    //测试三：
    // 1.给 person 类删去一个字段，age，
    // 2.使用最初正确的 serialVersionUID = 1123456777L
    // 2.(为了保证语法正确)在Person 类的 toString () 方法中删去 age 字段的 信息，
    // 3.依旧使用现存的 文件 basic-serializable-test/person.out,
    // 注意 ！！！====>执行 deserializeTest 方法，！！！成功了！！！，Person{name='小明', address='上海', email='null'}
    //
    //------------------------------------------------------------------------------------------------
}
