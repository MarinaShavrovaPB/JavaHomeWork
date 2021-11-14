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

    public static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда: ");
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                System.out.println(clothe);
            }
        }
    }
    public static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда: ");
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                System.out.println(clothe);
            }
        }

    }
}
