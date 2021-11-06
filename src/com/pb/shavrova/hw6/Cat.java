package com.pb.shavrova.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private String temperament;

    public Cat(String name, String food, String location) {
        super(name, food, location);
    }

    public Cat() {
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    @Override
    public void eat() {
        System.out.println("Кот ест");
    }

    @Override
    public void makeNoise() {
        System.out.println(this.getName() + " - произносит звуки - Мяу!");
    }

    @Override
    public String toString() {
        return "Животное: " + getName() + ", ест: " + getFood() + ", спит: " + getLocation();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(temperament);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Cat cat = (Cat) obj;
        if (temperament != cat.temperament)
            return false;

        return temperament == this.temperament;
    }
}
