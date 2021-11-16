package Dao;

import Db.DbBook;
import Entity.Book;

public class BooksDao {
    public void create(Book book) {
        DbBook.getInstance().create(book);
    }
    public Book booksFindById(String id){
       return DbBook.getInstance().booksFindById(id);
    }
    public Book[] findAll(){
       return DbBook.getInstance().findAll();
    }

}
