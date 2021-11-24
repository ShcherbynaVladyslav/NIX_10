package ua.com.alevel;

import org.junit.jupiter.api.*;
import ua.com.alevel.Entity.Book;
import ua.com.alevel.Service.BooksService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest {

    private static final BooksService booksService = new BooksService();

    public static final String NAME_OF_BOOK = "newNameBook";
    private static final String NAME_OF_BOOK_UPDATE = "newTestNameOfBook_update";
    private static final int DEFAULT_SIZE = 15;
    private static String createdISO;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Book book = generateBook(NAME_OF_BOOK + i);
            booksService.createBook(book);
        }
        Assertions.assertEquals(booksService.findAllBook().length, DEFAULT_SIZE);
    }

    @Test
    @Order(1)
    public void shouldByCreateCountryWhenCountryNameIsNotDuplicate() {
        Book book = generateRandomBook();
        booksService.createBook(book);
        createdISO = book.getId();
        Book[] books = booksService.findAllBook();
        Assertions.assertEquals(books.length, DEFAULT_SIZE + 1);
    }

    @Test
    @Order(2)
    public void shouldByCreateCountryWhenCountryNameIsDuplicate() {
        Book book = generateRandomBook();
        booksService.createBook(book);
        Book[] books = booksService.findAllBook();
        Assertions.assertEquals(books.length, DEFAULT_SIZE + 1);
    }

    @Test
    @Order(3)
    public void shouldBeUpdateCountryByISO() {
        Book book = generateRandomBook();
        book.setName(NAME_OF_BOOK_UPDATE);
        book.setId(createdISO);
        booksService.updateBook(book);
        book = booksService.booksFindById(book.getId());
        Assertions.assertEquals(NAME_OF_BOOK_UPDATE, book.getName());
    }

    @Test
    @Order(4)
    public void shouldBeDeleteCountryByISO() {
        Book book = generateRandomBook();
        booksService.deleteBook(createdISO);
        Assertions.assertEquals(booksService.findAllBook().length, DEFAULT_SIZE);
    }

    public static Book generateRandomBook() {
        Book book = new Book();
        book.setName(NAME_OF_BOOK);
        return book;
    }

    public static Book generateBook(String name) {
        Book book = new Book();
        book.setName(name);
        return book;
    }
}
