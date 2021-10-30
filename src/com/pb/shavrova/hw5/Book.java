package com.pb.shavrova.hw5;

public class Book {
    private String name;
    private String author;
    private int yearPublishing;

    public Book(String name, String author, int yearPublishing){
        this.name = name;
        this.author = author;
        this.yearPublishing = yearPublishing;
    }

    public Book() {
    }

    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public int getYearPublishing(){
        return yearPublishing;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYearPublishing(int yearPublishing) {
        this.yearPublishing = yearPublishing;
    }
    public String getInfo() {
        return "Название книги: " + name +", автор: " + author + ", год выпуска: "+yearPublishing;
    }
}
