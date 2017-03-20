package my.apps.db;

import my.apps.web.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by teodoramilitaru on 2/21/17.
 */
public class BookRepository {


    final static String URL = "jdbc:postgresql://IP:5432/test";
    final static String USERNAME = "fasttrackit_dev";
    final static String PASSWORD = "fasttrackit_dev";

    public void insert(Book book) throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO book( author, title, isbn, publishingyear) VALUES (?,?, ?, ?)");
        pSt.setString(1, book.getAuthor());
        pSt.setString(2, book.getTitle());
        pSt.setString(3, book.getIsbn());
        pSt.setInt(4, book.getPublishingyear());

        // 4. execute a prepared statement
        int rowsInserted = pSt.executeUpdate();
        System.out.println("Inserted " + rowsInserted + " rows.");

        // 5. close the objects
        pSt.close();
        conn.close();
    }
    public List<Book> read() throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        Statement st = conn.createStatement();

        // 4. execute a query
        ResultSet rs = st.executeQuery("SELECT author, title, isbn, publishingyear FROM article");

        // 5. iterate the result set and print the values
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book(
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("isbn"),
                    rs.getInt("publishingyear")

            );
            books.add(book);
        }


        // 6. close the objects
        rs.close();
        st.close();
        conn.close();
        return books;
    }

}

