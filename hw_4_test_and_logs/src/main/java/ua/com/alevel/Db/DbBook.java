package ua.com.alevel.Db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.Entity.Book;
import ua.com.alevel.Entity.Author;

import java.util.Arrays;
import java.util.UUID;

public class DbBook {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DbBook.class);
    private static final Logger LOGGER_INFO =  LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN =  LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR =  LoggerFactory.getLogger("error");

    private  Book[] books;
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

    public void createBook(Book book) {
        book.setId(generateId());
        if (books.length == booksCount)
            books = Arrays.copyOf(books, booksCount + 1);
        books[booksCount++] = book;
        LOGGER_INFO.info("Создана новая книга " + book.getName());
    }

    public void updateBook(Book book) {
        Book current = booksFindById(book.getId());
        if (current==null) return;
        current.setName(book.getName());
        LOGGER_INFO.info("Обновление книги " + book.getName());
    }

    public void deleteBook(String id) {
        int count = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getId().equals(id)) {
                count = i;
                break;
            }
        }
        if (count < 0 || books == null || count >= books.length) {
            LOGGER_ERROR.error("Книга " + booksFindById(id).getName() + " не найденна и не удалена!");
            System.out.println("Книга не найденна");
            return;
        }
        LOGGER_INFO.info("Книга " + booksFindById(id).getName() + " удалена!");
        Book[] temp = new Book[books.length - 1];
        for (int i = 0, k = 0; i < books.length; i++) {
            if (i == count) {
                continue;
            }
            temp[k++] = books[i];
        }
        booksCount--;
        books = Arrays.copyOf(temp, temp.length);
    }


    public Book booksFindById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        System.out.println("Пользователь не найден");
        LOGGER_WARN.warn("Неудачный поиск книги по id.");
        return null;
    }

    public Book[] findAll() {
        LOGGER_INFO.info("Нахождение всех книг");
        return books;
    }

    public void addAuthorToBook(Book book, Author author) {
        Book currentB = booksFindById(book.getId());
        if (currentB == null) {
            System.out.println("Книга не найдена");
            LOGGER_WARN.warn("Неудачный поиск книги по id.");
            return;
        }
        Author currentA = DbAuthor.getInstance().authorFindById(author.getId());
        if (currentA == null) {
            System.out.println("Автор не найдена");
            LOGGER_WARN.warn("Неудачный поиск автора по id.");
            return;
        }
        book.setAuthorBook(author.getName());
        System.out.println("Автор успешно добавлен.");
        LOGGER_INFO.info("Автор с id: " + author.getId() + " добавленно в книгу " + book.getName());
    }

    public boolean existByNameBook(String name){
        for (Book book: books) {
            if (book.getName().equals(name)) return true;
        }
        LOGGER_WARN.error("Выявленно несоответствие. Создание книги с существующим именем ");
        return false;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Book book : books) {
            if (book.getId().equals(id))
                return generateId();
        }
        LOGGER_INFO.info("Сгенерирован id для книги");
        return id;
    }
}
