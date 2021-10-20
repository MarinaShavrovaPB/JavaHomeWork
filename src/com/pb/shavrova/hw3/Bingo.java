package com.pb.shavrova.hw3;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        int a = 0;
        int b = 100;
        int count = 0;

        int random_number = a + (int) (Math.random() * b);
        System.out.println("Угадайте число от 1 до 100");

        Scanner scanner = new Scanner(System.in);

        while (a != random_number) {
            System.out.println("Введите загаданное число: ");
            String oper = scanner.next();
            char c = oper.charAt(0);

            if (isDigit(c)) {
                int operand = Integer.parseInt(oper);

                if (count == 100){
                    System.out.println("Вы использовали все попытки угадывания загаданного числа! Загаданное число было: "+random_number);
                    break;
                } else {
                    if (random_number == operand) {
                        count++;
                        System.out.println("Число угадано!" + "\nЧисло угадали с " + count + " попытки");
                        break;
                    } else if (random_number > operand) {
                        System.out.println("Введенное число меньше загаданного!");
                        count++;
                    } else if (random_number < operand) {
                        System.out.println("Введенное число больше загаданного!");
                        count++;
                    }
                }
            } else if (!isDigit(c)){
                if (oper.equals("x") || oper.equals("х")){
                    System.out.println("Вы вышли из программы!");
                    break;
                }else {
                    System.out.println("Для выхода из системы нажмите - \"x\"");
                }
            }
        }
    }
    public static boolean isDigit(char c){
        return Character.isDigit(c);
    }
}
