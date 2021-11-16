package Entity;


public class Author {
    private String id;
    private String name;
    private int idn;
    private String myBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdn() {
        return idn;
    }

    public void setIdn(int idn) {
        this.idn = idn;
    }

    public String getId() {
        return id;
    }

    public String getMyBooks() {
        return myBooks;
    }

    public void setMyBooks(String myBooks) {
        this.myBooks = myBooks;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author " +
                "IND "+ idn +'\''+
                "myBooks "+ myBooks +'\''+
                " name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
