import java.util.Date;

public class Book implements Comparable<Book>{

    private String name;
    private int pageCount;
    private String author;
    private String releaseDate;

    public Book(String name, int pageCount, String author, String releaseDate) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }
}
