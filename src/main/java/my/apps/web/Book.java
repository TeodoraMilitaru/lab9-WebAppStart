package my.apps.web;

/**
 * Created by teodoramilitaru on 2/21/17.
 */
public class Book {

    private String author;
    private String title;
    private String isbn;
    private Integer publishingyear;


    public Book(String author, String title, String isbn, Integer publishingyear) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publishingyear = publishingyear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getPublishingyear() {
        return publishingyear;
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
