package com.example.extendstest;

public class Animal {

    private Clothes clothes;

    public Animal() {
    }

    public Animal (Clothes clothes) {
        this.clothes = clothes;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }
}
