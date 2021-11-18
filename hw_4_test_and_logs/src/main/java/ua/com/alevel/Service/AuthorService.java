package ua.com.alevel.Service;

import ua.com.alevel.Dao.AuthorDao;
import ua.com.alevel.Entity.Author;
import ua.com.alevel.Entity.Book;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();

    public void createAuthor(Author author) {
        authorDao.createAuthor(author);
    }
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    public void deleteAuthor(String id){
        authorDao.deleteAuthor(id);
    }

    public Author authorFindById(String id) {
       return authorDao.authorFindById(id);
    }

    public void addBookToAuthor(Author author, Book book) {
        authorDao.addBookToAuthor(author, book);
    }

    public Author[] findAllAuthor() {
        return authorDao.findAll();
    }
}