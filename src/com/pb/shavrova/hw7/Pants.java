package com.pb.shavrova.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {

    public Pants(Size size, String color) {
        super(size, color);
    }

    public Pants(Size size, String color, double price) {
        super(size, color, price);
    }


    @Override
    public void dressMale() {
        System.out.println("Штаны одевает мужчина");
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны одевает женшина");
    }
}
