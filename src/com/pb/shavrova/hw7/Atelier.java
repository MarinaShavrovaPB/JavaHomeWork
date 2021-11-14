package com.pb.shavrova.hw7;

public class Atelier {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Tshirt(Size.XS, "белый", 250),
                new Tshirt(Size.L, "серый", 250),
                new Pants(Size.M, "черный", 500),
                new Pants(Size.XXS, "коричневый", 650),
                new Skirt(Size.S, "зеленый", 400),
                new Skirt(Size.M, "красный", 450),
                new Tie(Size.L, "синий", 170),
                new Tie(Size.L, "красный", 180),
        };
        dressMan(clothes);
        dressWomen(clothes);
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
