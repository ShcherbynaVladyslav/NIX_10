package ua.com.alevel.Controller;

import ua.com.alevel.Db.DbUser;
import ua.com.alevel.Entity.User;
import ua.com.alevel.Service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserController {

    private final UserService userService = new UserService();

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("1. Создать пользователя");
        System.out.println("2. Изменить пользователя");
        System.out.println("3. Удалить пользователя");
        System.out.println("4. Найти пользователя по id");
        System.out.println("5. Показать всех пользователей");
        System.out.println("0. Выход");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        try {
            System.out.println("Создание пользователя.\n");
            System.out.print("Введите имя: ");
            String name = reader.readLine();
            System.out.print("Введите email: ");
            String email = reader.readLine();
            if (DbUser.getInstance().existByEmail(email)) {
                System.out.println("Такой email уже существует.");
                return;
            }
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
            boolean emailRegex = matcher.find();
            if (!emailRegex) {
                System.out.println("Некорректный email!");
                return;
            }
            System.out.print("Введите возраст: ");
            String ageString = reader.readLine();
            int age = Integer.parseInt(ageString);
            User user = new User();
            user.setAge(age);
            user.setName(name);
            user.setEmail(email);
            userService.create(user);
            System.out.println();
            System.out.println("Пользователь создан");
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        try {
            System.out.println("Изменение пользователя.\n");
            User user = new User();
            System.out.print("Введите id пользователя: ");
            String id = reader.readLine();
            user.setId(id);
            System.out.print("Введите новое имя: ");
            String name = reader.readLine();
            user.setName(name);
            System.out.print("Введите новый возраст: ");
            String ageString = reader.readLine();
            int age = Integer.parseInt(ageString);
            user.setAge(age);
            userService.update(user);
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        try {
            System.out.println("Удаление пользователя.\n");
            System.out.print("Введите id: ");
            String id = reader.readLine();
            userService.delete(id);
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        try {
            System.out.println("Найти пользователя.\n");
            System.out.print("Введите id: ");
            String id = reader.readLine();
            User user = userService.findById(id);
            System.out.println(user);
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    private void findAll() {
        System.out.println("Список всех пользователей.\n");
        User[] users = userService.findAll();
        if (users != null && users.length != 0) {
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("Список пуст");
        }
    }
}