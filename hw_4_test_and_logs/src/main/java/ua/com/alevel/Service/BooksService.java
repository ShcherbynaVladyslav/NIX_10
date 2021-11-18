package ua.com.alevel.Service;

import ua.com.alevel.Dao.BooksDao;
import ua.com.alevel.Entity.Book;
import ua.com.alevel.Entity.Author;

public class BooksService {

    private final BooksDao booksDao = new BooksDao();

    public void createBook(Book book) {
        booksDao.createBook(book);
    }

    public void updateBook (Book book){
        booksDao.updateBook(book);
    }

    public void deleteBook(String id){
        booksDao.deleteBook(id);
    }

    public Book booksFindById(String id) {
        return booksDao.booksFindById(id);
    }

    public void addAuthorToBook(Book book, Author author) {
        booksDao.addAuthorToBook(book, author);
    }

    public Book[] findAllBook() {
        return booksDao.findAll();
    }
}