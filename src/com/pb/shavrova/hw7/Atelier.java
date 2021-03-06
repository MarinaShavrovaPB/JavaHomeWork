package com.pb.shavrova.hw7;

import com.pb.shavrova.hw6.Veterinarian;

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

        System.out.println("Список размеров: ");
        for(Size s : Size.values()) {
            System.out.println("Размер "+ s.name() + " соответствует значению - " + s.getEuroSize() + " евроразмера");
        }
        System.out.println();
        dressMan(clothes);
        System.out.println();
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда: ");
        for (Clothes clothe : clothes) {
            if (clothe instanceof ManClothes) {
                ((ManClothes) clothe).dressMale();
                System.out.println(clothe);
            }
        }
    }
    public static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда: ");
        for (Clothes clothe : clothes) {
            if (clothe instanceof WomenClothes) {
                ((WomenClothes) clothe).dressWomen();
                System.out.println(clothe);
            }
        }

    }

}
