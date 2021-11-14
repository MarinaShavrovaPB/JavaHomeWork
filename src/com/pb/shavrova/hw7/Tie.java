package com.pb.shavrova.hw7;

public class Tie extends Clothes implements ManClothes{

    public Tie(Size size, String color) {
        super(size, color);
    }

    public Tie(Size size, String color, double price) {
        super(size, color, price);
    }

    @Override
    public String toString() {
        return "Галстук (размер - " + getSize() +
                ", цвет - " + getColor() +
                ", цена - " + getPrice();
    }
}
