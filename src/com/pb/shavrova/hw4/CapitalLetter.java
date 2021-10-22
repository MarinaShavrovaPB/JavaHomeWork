package com.pb.shavrova.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для преобразования");
        String text = scanner.nextLine();
        System.out.println(toUpCase(text));
    }

    static String toUpCase(String text) {
        String[] words = text.split(" ");
        String output = "";
        for(String word:words){
            String first = word.substring(0,1).toUpperCase();
            String all = word.substring(1);
            output = output + " "+ first+all;
        }
        return output;
    }
}
