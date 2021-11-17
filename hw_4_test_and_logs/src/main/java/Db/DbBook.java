package Db;

import Entity.Book;
import Entity.Author;

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

    public void addAuthorToBook(Book book, Author author) {
        Book currentB = booksFindById(book.getId());
        if (currentB == null) {
            System.out.println("Автор не найден");
            return;
        }
        Author currentA = DbAuthor.getInstance().authorFindById(author.getId());
        if (currentA == null) {
            System.out.println("Автор не найдена");
            return;
        }
        book.setAuthorBook(book.getName());
        System.out.println("Автор успешно добавлен.");
    }

    public boolean existByNameBook(String name){
        for (Book book: books) {
            if (book.getName().equals(name)) return true;
        }
        return false;
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
