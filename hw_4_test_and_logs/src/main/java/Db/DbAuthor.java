package Db;

import Entity.Author;

import java.util.Arrays;
import java.util.UUID;

public class DbAuthor {

    private Author[] authors;
    private Author[] bookAuthor;
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

    public void addBookAuthor(Author author) {
        Author current = findById(author.getId());
        if (current == null) return;
        current.setMyBooks(author.setMyBooks(findById(create(bookAuthor))));

    }

    public Author findById(String id) {
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
