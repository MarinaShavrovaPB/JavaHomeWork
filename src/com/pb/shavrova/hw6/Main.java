package com.pb.shavrova.hw6;

public class Main {
    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();

        Animal animal1 = new Dog("Собака","мясо", "кровать");
        Animal animal2 = new Cat("Кот","рыба", "подушка =)");
        Animal animal3 = new Horse("Лошадь","сахарок", "конюшня");
        Animal[] animals = {animal1, animal2, animal3};

        animal1.makeNoise();
        animal2.makeNoise();
        animal3.makeNoise();

        animal1.sleep();
        animal2.sleep();
        animal3.sleep();

        System.out.println("\nНа прием пришли животные: ");
        for (Animal animal : animals) {
            veterinarian.treatAnimal(animal);
        }

    }
}
