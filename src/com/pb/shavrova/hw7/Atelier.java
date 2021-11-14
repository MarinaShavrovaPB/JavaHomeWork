package com.pb.shavrova.hw7;

import static com.pb.shavrova.hw7.Clothes.dressMan;
import static com.pb.shavrova.hw7.Clothes.dressWomen;

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


}
