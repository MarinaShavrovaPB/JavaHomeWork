package com.pb.shavrova.hw8;

public class WrongLoginException extends Exception {
    private String error;

    public WrongLoginException() {
        this.error = "Неправильно введен логин";
    }

    public WrongLoginException(String message) {
        super(message);
        this.error = message;
    }

    @Override
    public String toString() {
        return "Ошибка: " + this.error;
    }
}
