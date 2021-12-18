package com.pb.shavrova.hw11;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PhoneBook {
    private String name;
    private String surname;
    private String birthday;
    private List<String> phones;
    private String address;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDateTime dateOfEditing = LocalDateTime.now();;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getPhones() {
        return phones;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getDateOfEditing() {
        return dateOfEditing;
    }

    public PhoneBook(String name, String surname, String birthday, List<String> phones, String address) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phones = phones;
        this.address = address;
    }

    public void setDateOfEditing(LocalDateTime dateOfEditing) {

        this.dateOfEditing = dateOfEditing;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Данные из телефонной книги:" +
                "\n Имя - '" + name + '\'' +
                "\n Фамилия - '" + surname + '\'' +
                "\n День рождения - '" + birthday + '\'' +
                "\n Телефон - '" + phones + '\'' +
                "\n Адрес - '" + address + '\'' +
                "\n Дата внесения изменений - '" + dateOfEditing+ '\'';
    }
}
