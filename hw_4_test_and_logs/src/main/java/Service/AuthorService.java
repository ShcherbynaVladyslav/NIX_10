package Service;

import Dao.BooksDao;
import Dao.AuthorDao;
import Entity.Author;
import Entity.Book;

public class AuthorService {
    private final AuthorDao authorDao = new AuthorDao();
    private final BooksDao booksDao = new BooksDao();

    public void create(Author author) {
        authorDao.create(author);
    }

    public void addBooks(Author author, Book book) {
        authorDao.addBooks(author, book);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }

}
