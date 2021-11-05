package com.pb.shavrova.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String color;

    public Dog(String name, String food, String location) {
        super(name, food, location);
    }
    public Dog() {
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void eat() {
        System.out.println("Собака ест");
    }

    @Override
    public void makeNoise() {
        System.out.println(this.getName() + " - произносит звуки - Гав!");
    }
    @Override
    public String toString() {
        return "Животное: "+ getName()+", ест: "+getFood()+", спит: "+getLocation();
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }
        Dog dog = (Dog) obj;
        if (color != dog.color)
            return false;

        return color == this.color;
    }
}
