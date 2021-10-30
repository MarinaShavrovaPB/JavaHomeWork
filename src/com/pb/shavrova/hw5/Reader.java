package com.pb.shavrova.hw5;

import java.util.Arrays;

public class Reader {
    private String fio;
    private int numberTicket;
    private String dateOfBirth;
    private String faculty;
    private String phone;
    private String gender;

    public Reader(String fio, int numberTicket, String faculty, String dateOfBirth, String phone,String gender) {
        this.fio = fio;
        this.numberTicket = numberTicket;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    public Reader() {
    }
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getNumberTicket() {
        return numberTicket;
    }

    public void setNumberTicket(int numberTicket) {
        this.numberTicket = numberTicket;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDob(String dob) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void takeBook(int number) {
        System.out.println(this.fio + " взял"+gender(this.gender)+" "+ number +" "+ text(number)+"\n");
    }

    public void takeBook(String... books) {
        System.out.println(this.fio + " взял"+gender(this.gender)+ " книги:");
        for (String book : books) {
            System.out.println("- "+book);
        }
        System.out.println();
    }

    public void takeBook(Book... books) {
        System.out.println(this.fio + " взял"+gender(this.gender)+ " книги:");
        for (Book book : books) {
            System.out.println(book.getName()+" ("+substringText(book.getAuthor())+" "+book.getYearPublishing()+"г.)");
        }
        System.out.println();
    }

    public void returnBook(int number) {
        System.out.println(this.fio + " вернул"+gender(this.gender)+" "+ number +" "+ text(number)+"\n");
    }

    public void returnBook(String... books) {
        System.out.println(this.fio + " вернул"+gender(this.gender)+ " книги:");
        for (String book : books) {
            System.out.println("- "+book);
        }
        System.out.println();
     }

    public void returnBook(Book... books) {
        System.out.println(this.fio + " вернул"+gender(this.gender)+ " книги:");
        for (Book book : books) {
           System.out.println(book.getName()+" ("+substringText(book.getAuthor())+" "+book.getYearPublishing()+"г.)");
        }
        System.out.println();
    }

    public String getInfo() {
        return "Номер читательского: "+numberTicket+", ФИО читателя: " + fio +", дата рождения: " + dateOfBirth + ", номер телефона: "+phone+", факультет: "+faculty;
    }

    public String gender(String gender){
        if(gender.equals("f")){
            return "а";
        }
        return "";
    }
    public String text(int number){
        int last = number % 100;
        if (last > 10 && last < 21) {
            return "книг";
        }
        last = number % 10;
        if (last == 0 || last > 4) {
            return "книг";
        }
        if (last == 1) {
            return "книгу";
        }
        if (last < 5) {
            return "книги";
        }
        return "книги";
    }

    static String substringText(String text) {
        String[] strings = text.split(" ");
        String f = strings[0].substring(1);
        String name = strings[0].toUpperCase().charAt(0)+f+" "+strings[1].toUpperCase().charAt(0)+"."+strings[2].toUpperCase().charAt(0)+".";

     return name;
    }
}
