package com.pb.shavrova.hw8;

public class WrongPasswordException extends Throwable {
    private String error;

    public WrongPasswordException() {
        error = "Неправильно введен пароль";
    }

    public WrongPasswordException(String message) {
        super(message);
        error = message;
    }

    @Override
    public String toString() {
        return "Ошибка: " + error;
    }
}
