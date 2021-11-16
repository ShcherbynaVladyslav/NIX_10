package Dao;

import Db.DbAuthor;
import Db.DbBook;
import Entity.Author;
import Entity.Book;

public class AuthorDao {
    public void create(Author author) {
        DbAuthor.getInstance().create(author);
    }
    public Author authorFindById(String id){
        return DbAuthor.getInstance().authorFindById(id);
    }

    public void addBooks(Author author, Book book) {
        DbAuthor.getInstance().addBookAuthor(author, book);
    }

    public Author[] findAll() {
        return DbAuthor.getInstance().findAll();
    }
}
