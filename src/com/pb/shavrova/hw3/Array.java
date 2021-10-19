package com.pb.shavrova.hw3;
import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static int sumPlus = 0, count = 0, buf;
        public static void main(String[] args) {
            int size = 5;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите элементы массива: ");
            int[] array = new int[size];

            for (int i=0; i<size; i++){
                array[i] = scanner.nextInt();
            }
            System.out.println("Введенный пользователем массив: "+Arrays.toString(array));
            sum(array);
            sort(array);
            System.out.println("Отсортированный пузырьком массив: "+Arrays.toString(array)
                    +"\nСумма всех элементов массива: "+sumPlus
                    +"\nКоличество положительных элементов: "+count);
        }

    public static int sum(int[] array){
        for (int i=0; i != array.length; i++){
            if (array[i] > 0){
                sumPlus = sumPlus +array[i];
                count++;
            }
        }
            return sumPlus;
    }

    public static String sort(int[] array){
        for(int j = array.length-1 ; j > 0 ; j--) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    buf = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buf;
                }
            }
        }
        return Arrays.toString(array);
    }
}
