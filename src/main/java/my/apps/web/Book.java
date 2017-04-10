package my.apps.web;

/**
 * Created by teodoramilitaru on 2/21/17.
 */
public class Book {

    private Long id;
    private String author;
    private String title;
    private Integer isbn;
    private Integer publishingyear;

    public Book(String author, String title, Integer isbn, Integer publishingyear) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publishingyear = publishingyear;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public Integer getPublishingyear() {
        return publishingyear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public void setPublishingyear(Integer publishingyear) {
        this.publishingyear = publishingyear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishingyear='" + publishingyear + '\'' +
                '}';
    }

}
