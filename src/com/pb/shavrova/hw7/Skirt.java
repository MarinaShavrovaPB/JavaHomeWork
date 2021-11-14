package com.pb.shavrova.hw7;

public class Skirt extends Clothes implements WomenClothes{

    public Skirt(Size size, String color) {
        super(size, color);
    }

    public Skirt(Size size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public String toString() {
        return "Юбка (размер - " + getSize() +
                ", цвет - " + getColor() +
                ", цена - " + getPrice();
    }
}
