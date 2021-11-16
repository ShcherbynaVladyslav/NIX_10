package Db;

import Entity.Book;

import java.util.Arrays;
import java.util.UUID;

public class DbBook {

    private Book[] books;
    private static DbBook instance;
    private static int booksCount;

    public DbBook() {
        books = new Book[0];
        booksCount = 0;
    }

    public static DbBook getInstance() {
        if (instance == null)
            instance = new DbBook();
        return instance;
    }

    public void create(Book book) {
        book.setId(generateId());
        if (books.length == booksCount)
            books = Arrays.copyOf(books, booksCount + 1);
        books[booksCount++] = book;
    }

    public Book booksFindById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        System.out.println("Пользователь не найден");
        return null;
    }

    public Book[] findAll() {
        return books;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Book book : books) {
            if (book.getId().equals(id))
                return generateId();
        }
        return id;
    }
}
