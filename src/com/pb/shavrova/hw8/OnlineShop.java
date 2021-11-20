package com.pb.shavrova.hw8;
import java.util.Scanner;

import static com.pb.shavrova.hw8.Auth.input;

public class OnlineShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Перед входом, зарегистрируйтесь в системе:\n Введите логин:");
            String login = scanner.nextLine();
            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            System.out.println("Повторите пароль:");
            String confirmPassword = scanner.nextLine();

            input(login, password, confirmPassword);

            Auth auth = new Auth(login, password, confirmPassword);
            try {
                auth.signUp(login, password, confirmPassword);
            }catch (Exception e){
                System.err.println("Вы ввели неверно данные при регистрации");
                System.exit(1);
            }
            System.out.println("Регистрация прошла успешно!");
            System.out.println("Авторизуйтесь в системе\n Введите логин:");
            login = scanner.nextLine();
            System.out.println("Введите пароль:");
            password = scanner.nextLine();

            auth.signIn(login, password);

            System.out.println("Поздравляем Вы успешно авторизовались!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
