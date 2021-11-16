package Entity;


public class Author {
    private String id;
    private String name;
    private String idn;
    private String myBooks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdn() {
        return idn;
    }

    public void setIdn(String idn) {
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
