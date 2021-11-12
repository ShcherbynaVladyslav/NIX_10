package ua.com.alevel.Dao;

import ua.com.alevel.Db.DbUser;
import ua.com.alevel.Entity.User;

public class UserDao {

    public void create(User user) {
        DbUser.getInstance().create(user);
    }

    public void update(User user) {
        DbUser.getInstance().update(user);
    }

    public void delete(String id) {
        DbUser.getInstance().delete(id);
    }

    public User findById(String id) {
        return DbUser.getInstance().findById(id);
    }

    public User[] findAll() {
        return DbUser.getInstance().findAll();
    }

    public boolean existByEmail(String email) {
        return DbUser.getInstance().existByEmail(email);
    }
}