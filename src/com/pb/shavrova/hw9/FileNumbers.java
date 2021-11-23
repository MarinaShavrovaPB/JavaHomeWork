package com.pb.shavrova.hw9;

import java.io.*;

public class FileNumbers {
    private static String pathMain = "C:\\Users\\Marinka\\Desktop\\test_test\\";

    public static void main(String[] args) throws IOException {
        int[][] a = new int[10][10];
        int max_secret = 100;

        createFoulder();
        createArray(a, max_secret);

        createNumbersFile(a, pathMain + "numbers.txt");
        System.out.println("Преобразованный массив из файла:");
        int[][] nArr = createOddNumbersFile(pathMain + "numbers.txt"); // читаем из файла в другой массив для проверки
        createNumbersFile(nArr, pathMain + "odd-numbers.txt"); // сохраняем в файл

        printArray(nArr);
    }

    private static void createNumbersFile(int[][] arr, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    bw.write(String.valueOf(arr[i][j]) + " ");
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int[][] createArray(int[][] arr, int max_secret) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = (int) (Math.random() * max_secret);
            }
        }
        printArray(arr);
        return arr;
    }

    private static void printArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] createOddNumbersFile(String path) {
        int[][] arr = new int[10][10];
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (int i = 0; i < 10; i++) {
                String[] strArr = br.readLine().trim().split(" ");
                for (int j = 0; j < 10; j++) {
                    if (Integer.parseInt(strArr[j]) % 2 == 0) {
                        strArr[j] = String.valueOf(0);
                    }
                    arr[i][j] = Integer.parseInt(strArr[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    private static String createFoulder() {
        File theDir = new File(pathMain);

        if (!theDir.exists()) {
            System.out.println("Создание директории: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                System.out.println("Не удалось создать папку!");
            }
            if (result) {
                System.out.println("Директория создана");
            }
        }
        return "";
    }


}

