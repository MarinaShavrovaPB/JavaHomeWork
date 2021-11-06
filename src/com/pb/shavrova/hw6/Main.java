package com.pb.shavrova.hw6;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Dog animal1 = new Dog("Собака","мясо", "кровать");
        Cat animal2 = new Cat("Кот","рыба", "подушка =)");
        Horse animal3 = new Horse("Лошадь","сахарок", "конюшня");
        Animal[] animals = {animal1, animal2, animal3};

        animal1.makeNoise();
        animal2.makeNoise();
        animal3.makeNoise();

        animal1.sleep();
        animal2.sleep();
        animal3.sleep();

        System.out.println("-----------------------");
        for (Animal animal : animals) {
            animal.sleep();
            animal.makeNoise();
            animal.eat();
        }
        System.out.println("-----------------------");

        Class clazz = Class.forName("com.pb.shavrova.hw6.Veterinarian");
        Constructor constr = clazz.getConstructor(new Class[] {});
        Object obj = constr.newInstance();
        if (obj instanceof Veterinarian) {
            System.out.println("\nНа прием пришли животные: ");
            for (Animal animal : animals) {
                ((Veterinarian) obj).treatAnimal(animal);
            }
        }
    }
}
