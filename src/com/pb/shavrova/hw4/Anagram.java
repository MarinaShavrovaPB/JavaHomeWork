package com.pb.shavrova.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку:");
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строку:");
        String str2 = scanner.nextLine();
        if (toAnagram(str1, str2)){
            System.out.println("Строка является анограммой!");
        }else if (!toAnagram(str1, str2)) {
            System.out.println("Строка не является анограммой!");
        }
    }

    static boolean toAnagram(String s1, String s2) {

        s1=s1.toLowerCase();
        s2=s2.toLowerCase();

        String result1 = s1.replaceAll("[^A-Za-zА-Яа-я]", "");
        String result2 = s2.replaceAll("[^A-Za-zА-Яа-я]", "");

        char[] c1 = result1.toCharArray();
        char[] c2 = result2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }


}
