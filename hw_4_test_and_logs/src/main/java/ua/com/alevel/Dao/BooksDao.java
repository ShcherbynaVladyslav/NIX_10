package ua.com.alevel.Dao;

import ua.com.alevel.Db.DbBook;
import ua.com.alevel.Entity.Author;
import ua.com.alevel.Entity.Book;

public class BooksDao {

    public void createBook(Book book) {
        DbBook.getInstance().createBook(book);
    }

    public void updateBook(Book book){
        DbBook.getInstance().updateBook(book);
    }

    public void deleteBook(String id){
        DbBook.getInstance().deleteBook(id);
    }

    public Book booksFindById(String id){
       return DbBook.getInstance().booksFindById(id);
    }

    public void addAuthorToBook(Book book, Author author) {
        DbBook.getInstance().addAuthorToBook(book, author);
    }

    public Book[] findAll(){
       return DbBook.getInstance().findAll();
    }

}
