package com.pb.shavrova.hw10;

public class NumBox<T extends Number> {

    private final T[] numbers;

    public NumBox(int size) {
        this.numbers = (T[]) new Number[size];
    }

    public T get(int index) {
        return numbers[index];
    }

    public void set(int index, T numbers) {
        this.numbers[index] = numbers;
    }

    public void add(T num) {
        boolean arrayIndexOut = true;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == null) {
                    numbers[i] = num;
                    arrayIndexOut = false;
                    break;
                }
            }
        if(arrayIndexOut){
            try {
                throw new Exception("Достигнута максимальная длина массива!");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Массив переполнен! \n" +
                        "Необходимо уменьшить количество добавляемых элементов " +
                        "или же увеличить максимальную длину массива!");
                System.exit(1);
            }
        }
    }


    public double average() {
        return (sum() / length());
    }

    public double sum() {
        double sum = 0;
        for (T num : numbers) {
            if (num == null) {
                break;
            }
            sum += num.doubleValue();
        }
        return sum;
    }

    public int length() {
        int length = 0;
        for (T num : numbers) {
            if (num != null) {
                length++;
            }
        }
        return length;
    }

    public T max() {
        T max = numbers[0];
        for (T num : numbers) {
            if (num == null) {
                break;
            }
            if (max.doubleValue() < num.doubleValue()) {
                max = num;
            }
        }
        return max;
    }


}
