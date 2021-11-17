package Dao;

import Db.DbAuthor;
import Db.DbBook;
import Entity.Author;
import Entity.Book;

public class BooksDao {
    public void create(Book book) {
        DbBook.getInstance().create(book);
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
