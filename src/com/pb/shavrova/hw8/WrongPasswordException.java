package com.pb.shavrova.hw8;

public class WrongPasswordException extends Exception {
    private String error;

    public WrongPasswordException() {
        this.error = "Неправильно введен пароль";
    }

    public WrongPasswordException(String message) {
        super(message);
        this.error = message;
    }

    @Override
    public String toString() {
        return "Ошибка: " + this.error;
    }
}
