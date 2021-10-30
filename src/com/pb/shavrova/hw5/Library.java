package com.pb.shavrova.hw5;

public class Library {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Шаврова М.П.", 1, "механический", "23.10.1989", "+380931111111","f");
        Reader reader2 = new Reader("Бондаренко А.А.", 2, "информационные технологии", "30.08.1981", "+380672222222","m");
        Reader reader3 = new Reader("Шавров М.П.", 3, "компьютерная инженерия", "14.05.1983", "+380993333333","m");
        Reader[] readers = {reader1, reader2, reader3};

        Book book1 = new Book("Приключения", "Тест тест тесторович", 2021);
        Book book2 = new Book("Словарь", "Автор автор Авторович",2020);
        Book book3 = new Book("Энциклопедия", "Энциклопедист Энциклопедист Энциклопедистович", 1985);
        Book[] books = {book1, book2, book3};

        printReaders(readers);
        printBooks(books);

        reader1.takeBook(5);
        reader2.takeBook("Приключения", "Словарь", "Энциклопедия");
        reader3.takeBook(books);

        reader1.returnBook(3);
        reader2.returnBook("Приключения", "Словарь", "Энциклопедия");
        reader3.returnBook(books);
    }
    private static void printBooks(Book[] books) {
        System.out.println("Список книг:");
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
        System.out.println();
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("Список читателей:");
        for (Reader reader : readers) {
            System.out.println(reader.getInfo());
        }
        System.out.println();
    }
}
