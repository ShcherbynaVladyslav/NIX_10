package ua.com.alevel.Db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.Entity.Author;
import ua.com.alevel.Entity.Book;

import java.util.Arrays;
import java.util.UUID;

public class DbAuthor {

    private Author[] authors;
    private static DbAuthor instance;
    private static int authorCount;

    private static final Logger LOGGER = LoggerFactory.getLogger(DbAuthor.class);
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");


    private DbAuthor() {
        authors = new Author[0];
        authorCount = 0;
    }

    public static DbAuthor getInstance() {
        if (instance == null)
            instance = new DbAuthor();
        return instance;
    }

    public void createAuthor(Author author) {
        author.setId(generateId());
        if (authors.length == authorCount)
            authors = Arrays.copyOf(authors, authorCount + 1);
        authors[authorCount++] = author;
        LOGGER_INFO.info("Создана новый автор " + author.getName());
    }

    public void updateAuthor(Author author) {
        Author current = authorFindById(author.getId());
        if (current == null) return;
        current.setName(author.getName());
        LOGGER_INFO.info("Обновление автора " + author.getName());
    }

    public void deleteAuthor(String id) {
        int count = -1;
        for (int i = 0; i < authors.length; i++) {
            if (authors[i].getId().equals(id)) {
                count = i;
                break;
            }
        }
        if (count < 0 || authors == null || count >= authors.length) {
            LOGGER_ERROR.error("Автор " + authorFindById(id).getName() + " не найденн и не удалённ!");
            System.out.println("Пользователь не найден");
            return;
        }
        LOGGER_INFO.info("Автор " + authorFindById(id).getName() + " удалён!");
        Author[] temp = new Author[authors.length - 1];
        for (int i = 0, k = 0; i < authors.length; i++) {
            if (i == count) {
                continue;
            }
            temp[k++] = authors[i];
        }
        authorCount--;
        authors = Arrays.copyOf(temp, temp.length);
    }

    public Author[] findAll() {
        LOGGER_INFO.info("Нахождение всех книг");
        return authors;
    }

    public void addBookToAuthor(Author author, Book book) {
        Author currentA = authorFindById(author.getId());
        if (currentA == null) {
            System.out.println("Автор не найден");
            LOGGER_WARN.warn("Неудачный поиск Автора по id.");
            return;
        }
        Book currentB = DbBook.getInstance().booksFindById(book.getId());
        if (currentB == null) {
            System.out.println("Книга не найдена");
            LOGGER_WARN.warn("Неудачный поиск книги по id.");
            return;
        }
        author.setBookAuthor(book.getName());
        System.out.println("Книга успешно добавленна.");
        LOGGER_INFO.info("Книга с id: " + book.getId() + " добавленна автора " + author.getName());
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

    public boolean existByNameAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) return true;
        }
        LOGGER_WARN.error("Выявленно несоответствие. Создание автора с существующим именем ");
        return false;
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        for (Author author : authors) {
            if (author.getId().equals(id))
                return generateId();
        }
        LOGGER_INFO.info("Сгенерирован id для книги");
        return id;
    }
}
