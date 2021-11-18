package ua.com.alevel.Dao;

import ua.com.alevel.Db.DbAuthor;
import ua.com.alevel.Entity.Author;
import ua.com.alevel.Entity.Book;

public class AuthorDao {

    public void createAuthor(Author author) {
        DbAuthor.getInstance().createAuthor(author);
    }

    public void updateAuthor(Author author){
        DbAuthor.getInstance().updateAuthor(author);
    }

    public void deleteAuthor(String id){
        DbAuthor.getInstance().deleteAuthor(id);
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
