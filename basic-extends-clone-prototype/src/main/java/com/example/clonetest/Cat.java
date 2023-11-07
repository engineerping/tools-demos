package com.example.clonetest;

public class Cat implements Cloneable {
    private int age;
    private Clothes clothes;

    public Cat() {
    }

    public Cat(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clothes getClothes() {
        return this.clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    @Override
    protected Cat clone() {
        Cat cat = null;
        try {
            cat = (Cat) super.clone(); //调用默认的 clone 方法.
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cat;
    }
}
