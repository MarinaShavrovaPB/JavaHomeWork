package com.pb.shavrova.hw11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jdk.nashorn.internal.runtime.JSONListAdapter;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Main {
    public static List<PhoneBook> phoneBook = new ArrayList<>();
    public static ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws JsonProcessingException {
        // для работы с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
        mapper.registerModule(module);


        phoneBook.add(new PhoneBook("Тест_1", "Тест_1", "12.12.2000", Arrays.asList("380501111111", "380505555555"), "Тестовый"));
        phoneBook.add(new PhoneBook("Тест_2", "Тест_2", "01.12.2000", Arrays.asList("0989899899", "380501111100"), "Тестовый"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Телефонная книга \n Укажите номер пункта, действия по которому желаете выполнить:\n" +
                    "\n 1. Добавить контакт" +
                    "\n 2. Найти контакт" +
                    "\n 3. Удалить контакт" +
                    "\n 4. Запись в файл всех данных" +
                    "\n 5. Сортировать" +
                    "\n 6. Редактирование данных" +
                    "\n 7. Загрузка из файла всех данных" +
                    "\n 0. Выход");
            String action = scanner.next();
            switch (action) {
                case "1":
                case "Добавить контакт":
                case "1. Добавить контакт":
                    addContact(scanner);
                    break;
                case "2":
                case "Найти контакт":
                case "2. Найти контакт":
                    searchContact(scanner);
                    break;
                case "3":
                case "3. Удалить контакт":
                case "Удалить контакт":
                    deleteContact(scanner);
                    break;
                case "4":
                case "4. Запись в файл всех данных":
                case "Запись в файл всех данных":
                    importToFileContact();
                    break;
                case "5":
                case "Сортировать":
                case "5. Сортировать":
                    sortContact(scanner);
                    break;
                case "6":
                case "Редактирование данных":
                case "6. Редактирование данных":
                    editContact(scanner);
                    break;
                case "7":
                case "Загрузка из файла всех данных":
                case "7. Загрузка из файла всех данных":
                    exportToFileContact();
                    break;
                case "0":
                case "0. Выход":
                case "Выход":
                    System.out.println("Спасибо! До свидания!");
                    return;
                default:
                    System.out.println("Значение выбрано некорректно!");
            }
        }

    }

    public static void addContact(Scanner scanner) {
        System.out.println("Заполним данными телефонную книгу: ");
        System.out.println("Введите фамилию: ");
        String surname = scanner.next();

        System.out.println("Введите имя: ");
        String name = scanner.next();

        System.out.println("Введите день рождения: ");
        String birthday = scanner.next();

        System.out.println("Введите адрес: ");
        scanner.nextLine();
        String address = scanner.nextLine();
        boolean morePhone = true;
        List<String> phones = new ArrayList<>();

        while (morePhone) {
            System.out.println("Введите телефон: ");
            String phone = scanner.next();
            phones.add(phone);

            System.out.println("Желаете добавить еще один телефон?" +
                    "\n 1. Да" +
                    "\n 2. Нет");

            String test = scanner.next();

            if (Objects.equals(test, "2") || Objects.equals(test, "2. Нет") || Objects.equals(test, "Нет")) {
                morePhone = false;
            }
        }
        phoneBook.add(new PhoneBook(name, surname, birthday, phones, address));
        System.out.println("Данные успешно добавлены в телефонный справочник!\n");
    }

    public static void searchContact(Scanner scanner) throws JsonProcessingException {
        boolean searchElement = true;
        while (searchElement) {
            System.out.println("Вы желаете искать:" +
                    "\n 1. Телефон" +
                    "\n 2. Фамилия" +
                    "\n 3. Имя" +
                    "\n 4. Дата рождения" +
                    "\n 0. Выход \n");
            String searchContact = null;
            String test = scanner.next();

            if (Objects.equals(test, "1")) {
                searchElement = true;
                System.out.println("Введите телефон:");
                String phone = scanner.next();
                for (PhoneBook item : phoneBook) {
                    for(int i=0;i< item.getPhones().size(); i++ ){
                       if (item.getPhones().get(i).equals(phone)){
                           searchContact = item.toString();
                           break;
                       }
                    }

                }
                if (searchContact == null) {
                    System.out.println("Контакт не найден!");
                } else {
                    System.out.println(searchContact);
                }
            } else if (Objects.equals(test, "2")) {
                searchElement = true;
                System.out.println("Введите Фамилию:");
                String surname = scanner.next();

                for (PhoneBook item : phoneBook) {
                    if (Objects.equals(item.getSurname(), surname)) {
                        searchContact = item.toString();
                        break;
                    }
                }
                if (searchContact == null) {
                    System.out.println("Контакт не найден!");
                } else {
                    System.out.println(searchContact);
                }
            } else if (Objects.equals(test, "3")) {
                searchElement = true;
                System.out.println("Введите Имя:");
                String name = scanner.next();

                for (PhoneBook item : phoneBook) {
                    if (Objects.equals(item.getName(), name)) {
                        searchContact = item.toString();
                        break;
                    }
                }
                if (searchContact == null) {
                    System.out.println("Контакт не найден!");
                } else {
                    System.out.println(searchContact);
                }
            } else if (Objects.equals(test, "4")) {
                searchElement = true;
                System.out.println("Введите Дату рождения:");
                String birthday = scanner.next();

                for (PhoneBook item : phoneBook) {
                    if (Objects.equals(item.getBirthday(), birthday)) {
                        searchContact = item.toString();
                        break;
                    }
                }
                if (searchContact == null) {
                    System.out.println("Контакт не найден!");
                } else {
                    System.out.println(searchContact);
                }
            } else if (Objects.equals(test, "0")) {
                searchElement = false;
            } else {
                System.out.println("Нет возможности определить действие!");
                searchElement = false;
            }
        }
    }


    public static void deleteContact(Scanner scanner) {
        boolean delElement = true;
        while (delElement) {
            System.out.println("Вы желаете удалить:" +
                    "\n 1. Телефон" +
                    "\n 2. Запись по Фамилии и Имени" +
                    "\n 0. Выход \n");

            String test = scanner.next();
            if (Objects.equals(test, "1")) {
                delElement = true;
                System.out.println("Введите телефон, который хотите удалить:");
                String phone = scanner.next();
                List<String> myList = new ArrayList<String>(Arrays.asList(phone.split("")));

                boolean delPhone = phoneBook.removeIf(item -> Objects.equals(item.getPhones(), myList));
                if (delPhone) {
                    System.out.println("Телефон " + phone + " удален!");
                } else {
                    System.out.println("Контакт не найден!");
                }
            } else if (Objects.equals(test, "2")) {
                delElement = true;

                System.out.println("Введите фамилию: ");
                String surname = scanner.next();

                System.out.println("Введите имя: ");
                String name = scanner.next();

                boolean delName = phoneBook.removeIf(item -> Objects.equals(item.getName(), name) && Objects.equals(item.getSurname(), surname));
                if (delName) {
                    System.out.println("Контакт " + surname + " " + name + " удален!");
                } else {
                    System.out.println("Контакт не найден!");
                }

            } else if (Objects.equals(test, "0")) {
                delElement = false;
            } else {
                System.out.println("Нет возможности определить действие!");
                delElement = false;
            }
        }
    }


    public static void sortContact(Scanner scanner) {
        boolean sortElement = true;
        while (sortElement) {
            System.out.println("Вы желаете отсортировать список по:" +
                    "\n 1. Фамилия" +
                    "\n 2. Имя" +
                    "\n 3. Дата рождения" +
                    "\n 0. Выход \n");

            String test = scanner.next();
            if (Objects.equals(test, "1")) {
                sortElement = true;
                System.out.println("До сортировки:");
                for (PhoneBook i : phoneBook) {
                    System.out.println(i);
                }

                phoneBook.sort(Comparator.comparing(PhoneBook::getSurname));

                System.out.println("После сортировки:");
                for (PhoneBook i : phoneBook) {
                    System.out.println(i);
                }

            } else if (Objects.equals(test, "2")) {
                sortElement = true;
                System.out.println("До сортировки:");
                for (PhoneBook i : phoneBook) {
                    System.out.println(i);
                }

                phoneBook.sort(Comparator.comparing(PhoneBook::getName));

                System.out.println("После сортировки:");
                for (PhoneBook i : phoneBook) {
                    System.out.println(i);
                }

            } else if (Objects.equals(test, "3")) {
                sortElement = true;
                System.out.println("До сортировки:");
                for (PhoneBook i : phoneBook) {
                    System.out.println(i);
                }

                phoneBook.sort(Comparator.comparing(PhoneBook::getBirthday));

                System.out.println("После сортировки:");
                for (PhoneBook i : phoneBook) {
                    System.out.println(i);
                }

            } else {
                System.out.println("Нет возможности определить действие!");
                sortElement = false;
            }
        }
    }

    public static void editContact(Scanner scanner) {
        System.out.println("Введите данные пользователя, в контактах которого хотите изменить данные");
        System.out.println("Укажите фамилию:");
        String surname = scanner.next();
        System.out.println("Укажите имя:");
        String name = scanner.next();
        boolean editElement = true;
        String test = "";
        while (editElement) {
            System.out.println("Вы желаете отредактировать данные по:" +
                    "\n 1. Телефону" +
                    "\n 2. Дате рождения" +
                    "\n 3. Адресу" +
                    "\n 0. Выход \n");

                test = scanner.next();
                switch (test) {
                    case "1":
                        System.out.println("Введите новый телефон:");
                        String newPhone = scanner.next();
                        phoneBook.stream().filter(item -> Objects.equals(item.getName(), name) && Objects.equals(item.getSurname(), surname)).findFirst().ifPresent(item -> item.setAddress(newPhone));
                        break;
                    case "2":
                        System.out.println("Введите новую дату рождения:");
                        String newBirthday = scanner.next();
                        phoneBook.stream().filter(item -> Objects.equals(item.getName(), name) && Objects.equals(item.getSurname(), surname)).findFirst().ifPresent(item -> item.setAddress(newBirthday));
                        break;
                    case "3":
                        System.out.println("Введите новый адрес:");
                        String newAddress = scanner.nextLine();
                        phoneBook.stream().filter(item -> Objects.equals(item.getName(), name) && Objects.equals(item.getSurname(), surname)).findFirst().ifPresent(item -> item.setAddress(newAddress));
                        break;
                    case "0":
                        System.out.println("Выход!");
                        editElement = false;
                        break;
                    default:
                        System.out.println("Нет возможности определить действие!");
                        editElement = false;
                }
            LocalDateTime date = LocalDateTime.now();
                phoneBook.stream().filter(item -> Objects.equals(item.getName(), name)).findFirst().ifPresent(item -> item.setDateOfEditing(date));
            }

    }

    public static void importToFileContact() throws JsonProcessingException {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(phoneBook);

        try (Writer writer = new FileWriter("files\\json.txt")) {
            writer.write(json);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println(json);
    }

    public static void exportToFileContact() {
        try {
            String json = new String(Files.readAllBytes(Paths.get("files\\json.txt")), StandardCharsets.UTF_8);
            System.out.println(json);
                 } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

