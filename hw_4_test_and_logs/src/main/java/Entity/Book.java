package Entity;

import java.util.Arrays;

public class Book {
    private String id;
    private String name;
    private String[] myAuthor;
    private int authorCount;

    public Book() {
        myAuthor = new String[1];
        authorCount = 0;
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

    public String[] getAuthorBook() {
        return myAuthor;
    }

    public void setAuthorBook(String author) {
        if (myAuthor.length == authorCount)
            myAuthor = Arrays.copyOf(myAuthor, authorCount + 1);
        myAuthor[authorCount++] = author;
    }

    @Override
    public String toString() {
        return "Название книги = " + name + "." +
                " Авторство у = " + Arrays.toString(myAuthor)+"." +
                " id Книги= / " + id + " /.";
    }
}
