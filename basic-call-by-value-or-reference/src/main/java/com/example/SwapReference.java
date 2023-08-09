package com.example;

public class SwapReference {
    public static void main(String[] args) {
        Person a = new Person(19);
        Person b = new Person(20);

        swap(a, b);
        System.out.println("a: " + a.getAge());
        System.out.println("b: " + b.getAge());

        Person[] persons = new Person[] {a, b};
        swapInArray(persons);
        System.out.println("a: " + persons[0].getAge());
        System.out.println("b: " + persons[1].getAge());

    }

    /**
     * 交换不影响外部
     * 因为方法的形参只是它所接收的
     */

    private static void swap(Person x, Person y) {
        Person temp;
        temp = x;
        x = y;
        y = temp;
    }

    private static void swapInArray(Person[] persons) {
        Person temp;
        temp = persons[0];
        persons[0] = persons[1];
        persons[1] = temp;
    }
}
