package com.example;

class Person {
    private int age = 18;

    public Person() {

    }

    public Person(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void aroundAge() {
        this.age++;
    }
}
