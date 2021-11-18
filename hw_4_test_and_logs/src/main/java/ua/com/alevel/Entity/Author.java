package ua.com.alevel.Entity;

import java.util.Arrays;

public class Author {
    private String id;
    private String name;
    private String [] myBooks;
    private int booksCount;

    public Author() {
        myBooks = new String[1];
        booksCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getBookAuthor() {
        return myBooks;
    }

    public void setBookAuthor(String books) {
        if (myBooks.length == booksCount)
            myBooks = Arrays.copyOf(myBooks, booksCount + 1);
        myBooks[booksCount++] = books;
    }


    @Override
    public String toString() {
        return "Имя автора = " + name + "." +
                " Книги автора = " + Arrays.toString(myBooks)+"." +
                " id Автора=/ " + id + " /.";
    }
}