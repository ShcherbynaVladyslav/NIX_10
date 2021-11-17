package Service;

import Dao.AuthorDao;
import Entity.Author;
import Entity.Book;

public class AuthorService {

    private final AuthorDao authorDao = new AuthorDao();

    public void create(Author author) {
        authorDao.create(author);
    }

    public Author authorFindById(String id) {
       return authorDao.authorFindById(id);
    }

    public void addBookToAuthor(Author author, Book book) {
        authorDao.addBookToAuthor(author, book);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }
}