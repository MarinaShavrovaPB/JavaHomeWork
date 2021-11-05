package com.pb.shavrova.hw6;

import java.util.Objects;

public class Horse extends Animal {
    private String nameHorse;

    public Horse(String name, String food, String location) {
        super(name, food, location);
    }

    public Horse() {
    }

    public String getSameHorse() {
        return nameHorse;
    }

    public void nameSameHorse(String nameHorse) {
        this.nameHorse = nameHorse;
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест");
    }

    @Override
    public void makeNoise() {

        System.out.println(this.getName() + " - произносит звуки - Иго-го!");
    }


    @Override
    public String toString() {
        return "Животное: "+ getName()+", ест: "+getFood()+", спит: "+getLocation();
    }

    @Override
    public int hashCode() {
       return Objects.hashCode(nameHorse);
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
        Horse horse = (Horse) obj;
        if (nameHorse != horse.nameHorse)
            return false;

        return nameHorse == this.nameHorse;
    }

}
