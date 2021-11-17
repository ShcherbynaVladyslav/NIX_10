package Controller;

import Db.DbAuthor;
import Db.DbBook;
import Entity.Author;
import Entity.Book;

import Service.AuthorService;
import Service.BooksService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserController {

    private final AuthorService authorService = new AuthorService();
    private final BooksService booksService = new BooksService();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> createAuthor(reader);
            case "4" -> findAuthorById(reader);
            case "5" -> addBookToAuthor(reader);
            case "6" -> findAllAuthor();
            case "7" -> createBook(reader);
            case "10" -> findBooksById(reader);
            case "11" -> addAuthorToBook(reader);
            case "12" -> findAllBooks();

        }
        runNavigation();
    }

    public void createAuthor(BufferedReader reader) {
        try {
            System.out.println("Создание автора. Введите имя автора:");
            String fullName = reader.readLine();
            if (DbAuthor.getInstance().existByNameAuthor(fullName)) {
                System.out.println("Автор с таким именем уже существует");
                return;
            }
            Author author = new Author();
            author.setName(fullName);
            authorService.create(author);
            System.out.println("Автор создан.");
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    public void createBook(BufferedReader reader) {
        try {
            System.out.println("Создание книги. Введите название книги :");
            String bookName = reader.readLine();
            if (DbBook.getInstance().existByNameBook(bookName)) {
                System.out.println("Книга с таким названием уже существует");
                return;
            }
            Book book = new Book();
            book.setName(bookName);
            booksService.create(book);
            System.out.println("Книга создана.");
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    public void updateAuthor (BufferedReader reader) {
        System.out.println("Изменение автора");


    }

    public void addBookToAuthor(BufferedReader reader) {
        try {
            System.out.println("Выберите id автора котому хотите добавить книгу");
            findAllAuthor();
            String idAuthor = reader.readLine();
            Author author = authorService.authorFindById(idAuthor);
            System.out.print("Выберите id книги ");
            findAllBooks();
            String idBook = reader.readLine();
            Book book = booksService.booksFindById(idBook);
            authorService.addBookToAuthor(author, book);
            booksService.addAuthorToBook(book, author);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAuthorToBook(BufferedReader reader) {
        try {
            System.out.println("Выберите id книги, которому хотите добавить автора");
            findAllBooks();
            String idBook = reader.readLine();
            Book book = booksService.booksFindById(idBook);
            System.out.print("Выберите id автора. ");
            findAllAuthor();
            String idAuthor = reader.readLine();
            Author author = authorService.authorFindById(idAuthor);
            booksService.addAuthorToBook(book, author);
            authorService.addBookToAuthor(author, book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findAuthorById(BufferedReader reader) {
        try {
            System.out.println("Найти автора.\n");
            System.out.print("Введите id: ");
            String idAuthor = reader.readLine();
            Author author = authorService.authorFindById(idAuthor);
            System.out.println(author);
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    public void findBooksById(BufferedReader reader) {
        try {
            System.out.println("Найти книгу.\n");
            System.out.print("Введите id: ");
            String idBook = reader.readLine();
            Book book = booksService.booksFindById(idBook);
            System.out.println(book);
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    public void findAllAuthor() {
        System.out.println("Список всех авторов.");
        Author[] authors = authorService.findAll();
        if (authors != null && authors.length != 0) {
            for (Author author : authors) {
                System.out.println(author);
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    public void findAllBooks() {
        System.out.println("Список всех книг.");
        Book[] books = booksService.findAll();
        if (books != null && books.length != 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("Список пуст");
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("1. Добавить автора");
//        System.out.println("2. Изменить автора");
//        System.out.println("3. Удалить автора");
        System.out.println("4. Найти автора по id");
        System.out.println("5. Добавить книгу автору");
        System.out.println("6. Показать всех Авторов");
        System.out.println("7. Добавить книгу");
//        System.out.println("8. Изменить книгу");
//        System.out.println("9. Удалить книгу");
        System.out.println("10. Найти книгу по id");
        System.out.println("11. Добавить автора книге");
        System.out.println("12. Показать все книги");
        System.out.println();
        System.out.println("0. Выход");
    }
}