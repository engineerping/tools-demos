package com.example.extendstest;

public class Cat extends Animal{
    int age;

    public Cat() {
    }

    public Cat(Clothes clothes) {
        super(clothes);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
