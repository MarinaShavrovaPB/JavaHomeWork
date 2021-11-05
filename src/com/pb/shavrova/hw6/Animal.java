package com.pb.shavrova.hw6;

public abstract class Animal {
    private String food;
    private String location;
    private String name;

    public Animal() {
    }

    public Animal(String name, String food, String location) {
        this.food = food;
        this.location = location;
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void eat();

    public void makeNoise(){};

    public void sleep() {
        System.out.println(this.name + " спит... хрррр...");
    }

}
