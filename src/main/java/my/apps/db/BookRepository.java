package my.apps.db;

import my.apps.web.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        System.out.println("Inserted " + rowsInserted + " rows.")

        // 5. close the objects
        pSt.close();
        conn.close();
    }
}
}
