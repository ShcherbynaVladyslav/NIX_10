package ua.com.alevel;

import org.junit.jupiter.api.*;
import ua.com.alevel.Entity.Author;
import ua.com.alevel.Service.AuthorService;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthorTest {

    private static final AuthorService authorService = new AuthorService();

    public static final String NAME_OF_AUTHOR = "newNameAuthor";
    private static final String NAME_OF_AUTHOR_UPDATE = "newTestNameOfAuthor_update";
    private static final int DEFAULT_SIZE = 15;
    private static String createdISO;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            Author author = generateAuthor(NAME_OF_AUTHOR + i);
            authorService.createAuthor(author);
        }
        Assertions.assertEquals(authorService.findAllAuthor().length, DEFAULT_SIZE);
    }

    @Test
    @Order(1)
    public void shouldByCreateCountryWhenCountryNameIsNotDuplicate() {
        Author author = generateRandomAuthor();
        authorService.createAuthor(author);
        createdISO = author.getId();
        Author[] authors = authorService.findAllAuthor();
        Assertions.assertEquals(authors.length, DEFAULT_SIZE + 1);
    }

    @Test
    @Order(2)
    public void shouldByCreateCountryWhenCountryNameIsDuplicate() {
        Author author = generateRandomAuthor();
        authorService.createAuthor(author);
        Author[] authors = authorService.findAllAuthor();
        Assertions.assertEquals(authors.length, DEFAULT_SIZE + 1);
    }

    @Test
    @Order(3)
    public void shouldBeUpdateCountryByISO() {
        Author author = generateRandomAuthor();
        author.setName(NAME_OF_AUTHOR_UPDATE);
        author.setId(createdISO);
        authorService.updateAuthor(author);
        author = authorService.authorFindById(author.getId());
        Assertions.assertEquals(NAME_OF_AUTHOR_UPDATE, author.getName());
    }

    @Test
    @Order(4)
    public void shouldBeDeleteCountryByISO() {
        Author author = generateRandomAuthor();
        authorService.deleteAuthor(createdISO);
        Assertions.assertEquals(authorService.findAllAuthor().length, DEFAULT_SIZE);
    }

    public static Author generateRandomAuthor() {
        Author author = new Author();
        author.setName(NAME_OF_AUTHOR);
        return author;
    }

    public static Author generateAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }
}
