package Controller;

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
    //private final Book book = f();

    int authorIDN = 1;
    int bookIDN = 1;

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
            case "5" -> addBookAuthor(reader);
            case "6" -> findAllAuthor();
            case "7" -> createBook(reader);
            case "10" -> findBooksById(reader);
            case "12" -> findAllBooks();

        }
        runNavigation();
    }

    public void createAuthor(BufferedReader reader) {
        try {
            System.out.println("Создание автора");
            System.out.println("Введите имя автора ");
            String fullName = reader.readLine();

            //if () поиск существует ли такой автор

            Author author = new Author();
            author.setName(fullName);
            authorService.create(author);
            System.out.println("Автор создан.");
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }


    public void addBookAuthor(BufferedReader reader) {
        try {
            System.out.println("Выберите автора которому хотите добавить книгу");
            findAllAuthor();
            Author author = new Author();
            Book book = new Book();
            System.out.println("Введите id автора");
            String id = reader.readLine();
            author.setId(id);
            findAllBooks();
            System.out.println("Выберете id книги");
            String idBook = reader.readLine();
            author.setIdn(idBook);
            authorService.addBooks(author, book);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createBook(BufferedReader reader) {
        try {
            System.out.println("Создание книги");
            System.out.println("Введите название книги ");
            String bookName = reader.readLine();

            //if () поиск существует ли такой автор

            Book book = new Book();
            book.setName(bookName);
            book.setIdn(bookIDN);
            bookIDN++;
            booksService.create(book);
            System.out.println("Книга создана.");
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
    }

    public Book findBooksById(BufferedReader reader) {
        try {
            System.out.println("Найти книгу.\n");
            System.out.print("Введите id: ");
            String id = reader.readLine();
            Book book = booksService.findById(id);
            System.out.println(book);
        } catch (IOException e) {
            System.out.println("exception: = " + e.getMessage());
        }
        return null;
    }

    public void findAllAuthor() {
        System.out.println("Список всех авторов.\n");
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
        System.out.println("Список всех книг.\n");
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
//        System.out.println("4. Найти автора по id");
        System.out.println("5. Добавить книгу автору");
        System.out.println("6. Показать всех Авторов");
        System.out.println();
        System.out.println("7. Добавить книгу");
//        System.out.println("8. Изменить книгу");
//        System.out.println("9. Удалить книгу");
        System.out.println("10. Найти книгу по id");
//        System.out.println("11. Добавить автора книге");
        System.out.println("12. Показать все книги");
//        System.out.println();
        System.out.println("0. Выход");
        System.out.println();
    }
}