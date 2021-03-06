package com.pb.shavrova.hw8;

import java.util.HashMap;

public class Auth {
    private String login;
    private String password;
    private String confirmPassword;

    private String loginNew;
    private String passwordNew;

    public String getLoginNew() {
        return loginNew;
    }

    public void setLoginNew(String loginNew) {
        this.loginNew = loginNew;
        System.out.println(loginNew);
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
        System.out.println(passwordNew);
    }

    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void signUp(String login, String password, String confirmPassword) {
        try {
            checkLoginInfo(login, "^[a-zA-Z0-9]{5,20}$");
            checkPasswordInfo(password, confirmPassword, "^[a-zA-Z0-9_]{5,}$");
            myBD(login, password);

        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            System.err.println("Вы ввели неверно данные при регистрации");
            System.exit(1);
        }
    }

    public void signIn(String login, String password) {
        String loginDB = testBD.get("login");
        String passwordDB = testBD.get("password");
        if (isNullOrEmpty(login) || isNullOrEmpty(password)) {
            try {
                throw new Exception("String can not be empty!");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Поля с данными не могут быть пустыми");
                System.exit(1);
            }
        }
        try {
            validLoginAndPasswor(login, password, loginDB, passwordDB);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            System.err.println("Вы ввели неверно данные при авторизации");
            System.exit(1);

        }
    }

    private boolean validLoginAndPasswor(String login, String password, String loginDB, String passwordDB) throws WrongLoginException, WrongPasswordException {
        if (!loginDB.equals(login)) {
            throw new WrongLoginException();
        } else if (!passwordDB.equals(password)) {
            throw new WrongPasswordException();
        }
        return true;
    }

    private boolean checkLoginInfo(String login, String regexLogin)
            throws WrongLoginException {
        if (!login.matches(regexLogin)) {
            throw new WrongLoginException("Неправильно введен логин!");
        }
        return true;
    }

    private boolean checkPasswordInfo(String password, String confirmPassword, String regexPass)
            throws WrongPasswordException {
        if ((!password.matches(regexPass)) || (!password.equals(confirmPassword))) {
            throw new WrongPasswordException("Неправильно введен пароль!");
        }
        return true;
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String input(String login, String password, String confirmPassword) {
        String s = null;
        if (Auth.isNullOrEmpty(login) || Auth.isNullOrEmpty(password) || Auth.isNullOrEmpty(confirmPassword)) {
            try {
                throw new Exception("Не заполнено поле логин или пароль!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return s;
    }

    private static HashMap<String, String> testBD;

    public void myBD(String login, String password) {
        testBD = new HashMap<>();
        testBD.put("login", login);
        testBD.put("password", password);
    }
}
