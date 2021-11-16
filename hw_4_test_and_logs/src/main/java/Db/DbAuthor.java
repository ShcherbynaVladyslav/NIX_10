package Db;

import Entity.Author;
import Entity.Book;

import java.util.Arrays;
import java.util.UUID;

public class DbAuthor {

    private Author[] authors;
    private static DbAuthor instance;
    private static int authorCount;

    private DbAuthor() {
        authors = new Author[0];
        authorCount = 0;
    }

    public static DbAuthor getInstance() {
        if (instance == null)
            instance = new DbAuthor();
        return instance;
    }

    public void create(Author author) {
        author.setId(generateId());
        if (authors.length == authorCount)
            authors = Arrays.copyOf(authors, authorCount + 1);
        authors[authorCount++] = author;
    }

    public Author[] findAll() {
        return authors;
    }

    public void addBookAuthor(Author author, Book book) {
        Author currentA = authorFindById(author.getId());
        if (currentA == null) {
            System.out.println("Автор не найден");
            return;
        }
        Book currentB = DbBook.getInstance().booksFindById(book.getId());
        if (currentB == null) {
            System.out.println("Книга не найдена");
            return;
        }
        author.setMyBooks(book.getName());

    }

    public Author authorFindById(String id) {
        for (Author author : authors) {
            if (author.getId().equals(id)) {
                return author;
            }
        }
        System.out.println("автор не найден");
        return null;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Author author : authors) {
            if (author.getId().equals(id))
                return generateId();
        }
        return id;
    }
}
