package com.pb.shavrova.hw13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> buffer = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();

    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            System.out.println("Начало работы нового потребителя.");
            while (true) {
                try {
                    consumerTest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void consumerTest() throws InterruptedException {
            synchronized (buffer) {
                while (buffer.size() == 0) {
                    System.out.println("Потребитель ожидает пока в буфере появятся данные...");
                    buffer.wait();
                }
                System.out.println("Потребитель считал содержимое буфера:");
                System.out.println("Данные в буфере:");
                for (Integer s : buffer) {
                    System.out.print(s + " ");
                }
                buffer.clear();
                System.out.println("\nБуфер пуст!");
                buffer.notifyAll();
            }
        }
    }


    static class Producer implements Runnable {
        @Override
        public void run() {
            System.out.println("Начало работы нового производителя.");
            while (true) {
                try {
                    producerTest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void producerTest() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == 5) {
                System.out.println("Производитель ожидает, пока потребтель \"потребляет\" данные из буфера...");
                buffer.wait();
            }
            while (buffer.size() < 5) {
                buffer.add((int) (Math.random() * 100));
            }
            System.out.println("Буфер заполнен производителем!");
            System.out.println("Данные в буфере:");
            for (Integer s : buffer)
                System.out.print(s + " ");
            System.out.println("\nРабота производителя приостановлена на 5 секунд!");
            Thread.currentThread().sleep(5000);
            buffer.notifyAll();
        }
    }
}
