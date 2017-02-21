package my.apps.web;

/**
 * Created by teodoramilitaru on 2/21/17.
 */
public class Books {

    private String author;
    private String title;
    private String isbn;
    private String publishingyear;


    public Books(String author, String title, String isbn, String publishingyear) {
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

    public String getPublishingyear() {
        return publishingyear;
    }


    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishingyear='" + publishingyear + '\'' +
                '}';
    }

}
