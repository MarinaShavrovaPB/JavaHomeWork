package com.pb.shavrova.hw7;

public abstract class Clothes {
    private Size size;
    private String color;
    private double price;

    public Clothes(Size size, String color) {
        this.size = size;
        this.color = color;
    }
    public Clothes(Size size, String color, double price) {
        this(size, color);
        this.price = price;
    }

    public Size getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Одежда в наличии: " +
                "размер " + size +
                ", цвет " + color + '\'' +
                ", цена " + price;
    }
}
