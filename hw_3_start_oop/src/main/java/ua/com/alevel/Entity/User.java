package ua.com.alevel.Entity;

public class User {

    private String id;
    private String name;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Пользователь " +
                "ID = '" + id + '\'' +
                ", ИМЯ = '" + name + '\'' +
                ", EMAIL = '" + email + '\'' +
                ", ВОЗРАСТ = " + age;
    }
}