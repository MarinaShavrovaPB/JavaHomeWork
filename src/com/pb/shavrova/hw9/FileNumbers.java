package com.pb.shavrova.hw9;


import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class FileNumbers {
    private static String pathMain = "files\\";
    private static final Logger LOGGER = Logger.getLogger("MyLog");
    private static FileHandler fh;

    public static void main(String[] args) throws IOException {
        LOGGER.info("Запись логов:");

        createFoulder();
        try {
            LOGGER.setUseParentHandlers(false);
            fh = new FileHandler(pathMain + "MyLogFile.log",true);
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
            LOGGER.warning("ERROR!" + e);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.warning("ERROR!" + e);
        }

        int[][] a = new int[10][10];
        int min = 1;
        int max = 100;

        createArray(a, min, max);
        createNumbersFile(a, pathMain + "numbers.txt");

        System.out.println("Преобразованный массив из файла:");
        int[][] nArr = createOddNumbersFile(pathMain + "numbers.txt"); // читаем из файла в другой массив для проверки


        createNumbersFile(nArr, pathMain + "odd-numbers.txt"); // сохраняем в файл
        printArray(nArr);

        LOGGER.info("Успешное записывание логов!");
    }

    private static String createNumbersFile(int[][] arr, String path) {
        LOGGER.info("Запись данных в файл. Путь к файлу: "+path);
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
            LOGGER.warning("ERROR: Ошибка записи массива в файл! " + path);
        }
        return path;
    }


    private static int[][] createArray(int[][] arr,int min, int max) {
        LOGGER.info("Создание массива с рандомными числами от 1 до 99");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = (int) (Math.random() * max*min);
            }
        }
        printArray(arr);
        return arr;
    }

    private static void printArray(int[][] arr) {
        LOGGER.info("Вывод массива в консоль");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] createOddNumbersFile(String path) {
        LOGGER.info("Считывание файла, с заменой четных чисел на 0");
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
            LOGGER.warning("ERROR!" + e);

        }
        return arr;
    }

    private static void createFoulder() {
        File theDir = new File(pathMain);
        if (!theDir.exists()) {
            LOGGER.info("Создание директории: " + theDir.getName());
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                LOGGER.warning("ERROR!" + se + " Не удалось создать папку!");
            }
            if (result) {
                LOGGER.info("Директория создана");

            }
        }
    }


}

