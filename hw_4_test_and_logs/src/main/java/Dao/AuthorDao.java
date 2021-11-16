package Dao;

import Db.DbAuthor;
import Entity.Author;
import Entity.Book;

public class AuthorDao {
    public void create(Author author) {
        DbAuthor.getInstance().create(author);
    }

    public void addBooks(Author author, Book book) {
        DbAuthor.getInstance().addBookAuthor(author, book);
    }

    public Author[] findAll() {
        return DbAuthor.getInstance().findAll();
    }
}
