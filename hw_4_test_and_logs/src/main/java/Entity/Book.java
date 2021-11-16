package Entity;

public class Book {
    private String id;
    private String name;
    private int idn;

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

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Books " +
                "IND "+ idn +'\''+
                " name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
