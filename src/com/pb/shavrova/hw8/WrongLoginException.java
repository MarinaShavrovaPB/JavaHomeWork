package com.pb.shavrova.hw8;

public class WrongLoginException extends Exception {
    private String error;

    public WrongLoginException() {
        error = "Неправильно введен логин";
    }

    public WrongLoginException(String message) {
        super(message);
        error = message;
    }

    @Override
    public String toString() {
        return "Ошибка: " + error;
    }
}
