package com.pb.shavrova.hw2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение первого числа: ");
        int operand1 = scanner.nextInt();
        System.out.println("Введите значение второго числа: ");
        int operand2 = scanner.nextInt();
        System.out.println("Введите элемент вычисления: \"/\" \"*\" \"+\" \"-\"");
        String sign = scanner.next();

if (sign.equals("/") && operand2 == 0){
    System.out.println("На ноль делить нельзя!!!");
} else {
        switch (sign){
            case "/":
                System.out.println("Результат деления: "+operand1/operand2);
                break;
            case "*":
                System.out.println("Результат умножения: "+operand1*operand2);
                break;
            case "+":
                System.out.println("Результат сложения: "+(operand1+operand2));
                break;
            case "-":
                System.out.println("Результат вычитания: "+(operand1-operand2));
                break;
        }
    }
    }
    }
