package com.pb.shavrova.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int operand1 = scanner.nextInt();

        if (operand1 >= 0 && operand1 <= 14){
            System.out.println("Введенное число входит в промежуток [0 - 14]");
        }else if (operand1 >= 15 && operand1 <= 35){
            System.out.println("Введенное число входит в промежуток [15 - 35]");
        }else if (operand1 >= 36 && operand1 <= 50){
            System.out.println("Введенное число входит в промежуток [36 - 50]");
        }else if (operand1 >= 51 && operand1 <= 100){
            System.out.println("Введенное число входит в промежуток [51 - 100]");
        } else {
            System.out.println("Введенное число не попадает ни в один из заданных промежутков");
        }
    }
}
