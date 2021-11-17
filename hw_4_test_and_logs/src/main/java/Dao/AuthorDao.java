package Dao;

import Db.DbAuthor;
import Entity.Author;
import Entity.Book;

public class AuthorDao {

    public void create(Author author) {
        DbAuthor.getInstance().create(author);
    }
    public Author authorFindById(String id){
        return DbAuthor.getInstance().authorFindById(id);
    }

    public void addBookToAuthor(Author author, Book book) {
        DbAuthor.getInstance().addBookToAuthor(author, book);
    }

    public Author[] findAll() {
        return DbAuthor.getInstance().findAll();
    }
}
