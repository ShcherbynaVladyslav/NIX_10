package Dao;

import Db.DbAuthor;
import Entity.Author;

public class AuthorDao {
    public void create(Author author) {
        DbAuthor.getInstance().create(author);
    }

    public void addBooks(Author author) {
        DbAuthor.getInstance().addBookAuthor(author);
    }

    public Author[] findAll() {
        return DbAuthor.getInstance().findAll();
    }
}
