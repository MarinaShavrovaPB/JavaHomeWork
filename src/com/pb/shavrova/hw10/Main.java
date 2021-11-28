package com.pb.shavrova.hw10;

public class Main {

    public static void main(String []args) throws Exception {

        NumBox<Integer> arrInt = new NumBox<>(5);
           try {
               arrInt.add(1);
               arrInt.add(6);
               arrInt.add(3);
               arrInt.add(4);
           }catch (Exception e) {
               e.printStackTrace();
           }

        System.out.println("----- Значения для \"Integer\" -----");
        System.out.println("Текущее количество элементов: \t\t\t\t\t| "+arrInt.length());
        System.out.println("Число под индексом 3: \t\t\t\t\t\t\t| "+arrInt.get(3));
        System.out.println("Среднее арифметическое элементов массива: \t\t| "+arrInt.average());
        System.out.println("Максимальный элемент массива: \t\t\t\t\t| "+arrInt.max());
        System.out.println("Сумма всех элементов массива: \t\t\t\t\t| "+arrInt.sum());

        NumBox<Double> arrDouble = new NumBox<>(5);
        try {
            arrDouble.add(1.2);
            arrDouble.add(6.5);
            arrDouble.add(5.1);
            arrDouble.add(3.2);
            arrDouble.add(4.9);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("----- Значения для \"Double\" -----");
        System.out.println("Текущее количество элементов: \t\t\t\t\t| "+arrDouble.length());
        System.out.println("Число под индексом 2: \t\t\t\t\t\t\t| "+arrDouble.get(2));
        System.out.println("Среднее арифметическое элементов массива: \t\t| "+arrDouble.average());
        System.out.println("Максимальный элемент массива: \t\t\t\t\t| "+arrDouble.max());
        System.out.println("Сумма всех элементов массива: \t\t\t\t\t| "+arrDouble.sum());

        NumBox<Float> arrFloat = new NumBox<>(5);
        try {
            arrFloat.add(1.2f);
            arrFloat.add(6f);
            arrFloat.add(7f);
            arrFloat.add(3.2f);
            arrFloat.add(2f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("----- Значения для \"Float\" -----");
        System.out.println("Текущее количество элементов: \t\t\t\t\t| "+arrFloat.length());
        System.out.println("Число под индексом 2: \t\t\t\t\t\t\t| "+arrFloat.get(2));
        System.out.println("Среднее арифметическое элементов массива: \t\t| "+arrFloat.average());
        System.out.println("Максимальный элемент массива: \t\t\t\t\t| "+arrFloat.max());
        System.out.println("Сумма всех элементов массива: \t\t\t\t\t| "+arrFloat.sum());

    }
}
