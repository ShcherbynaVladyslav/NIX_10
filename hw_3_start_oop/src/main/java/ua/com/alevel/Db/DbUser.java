package ua.com.alevel.Db;

import ua.com.alevel.Entity.User;

import java.util.Arrays;
import java.util.UUID;

public class DbUser {

    private User[] users;
    private static DbUser instance;
    private static int usersCount;

    private DbUser() {
        users = new User[0];
        usersCount = 0;
    }

    public static DbUser getInstance() {
        if (instance == null)
            instance = new DbUser();
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
        if (users.length == usersCount)
            users = Arrays.copyOf(users, usersCount + 1);
        users[usersCount++] = user;
    }

    public void update(User user) {
        User current = findById(user.getId());
        if (current == null)
            return;
        current.setAge(user.getAge());
        current.setName(user.getName());
    }

    public void delete(String id) {
        int count = -1;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId().equals(id)) {
                count = i;
                break;
            }
        }
        if (count < 0 || users == null || count >= users.length) {
            System.out.println("Пользователь не найден");
            return;
        }
        User[] temp = new User[users.length - 1];
        for (int i = 0, k = 0; i < users.length; i++) {
            if (i == count) {
                continue;
            }
            temp[k++] = users[i];
        }
        usersCount--;
        users = Arrays.copyOf(temp, temp.length);
    }

    public User findById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        System.out.println("Пользователь не найден");
        return null;
    }

    public User[] findAll() {
        return users;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (User user : users) {
            if (user.getId().equals(id))
                return generateId();
        }
        return id;
    }

    public boolean existByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }
}