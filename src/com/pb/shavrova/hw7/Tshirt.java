package com.pb.shavrova.hw7;

public class Tshirt extends Clothes implements WomenClothes, ManClothes{

    public Tshirt(Size size, String color) {
        super(size, color);
    }

    public Tshirt(Size size, String color, double price) {
        super(size, color, price);
    }


    @Override
    public void dressMale() {
        System.out.println("Футболки носит мужчина");
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболки носит женщина");
    }
}
