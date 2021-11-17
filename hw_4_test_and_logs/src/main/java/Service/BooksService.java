package Service;

import Dao.BooksDao;
import Entity.Book;
import Entity.Author;

public class BooksService {

    private final BooksDao booksDao = new BooksDao();

    public void create(Book book) {
        booksDao.create(book);
    }

    public Book booksFindById(String id) {
        return booksDao.booksFindById(id);
    }

    public void addAuthorToBook(Book book, Author author) {
        booksDao.addAuthorToBook(book, author);
    }

    public Book[] findAll() {
        return booksDao.findAll();
    }
}