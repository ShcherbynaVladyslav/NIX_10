package Service;

import Dao.BooksDao;
import Entity.Book;

public class BooksService {
    private final BooksDao booksDao = new BooksDao();

    public void create (Book book){
     booksDao.create(book);
    }
    public Book findById(String id){
       return booksDao.findById(id);
    }
    public Book[] findAll () {
        return booksDao.findAll();
    }
}
