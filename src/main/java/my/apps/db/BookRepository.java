package my.apps.db;

import my.apps.web.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by teodoramilitaru on 2/21/17.
 */
public class BookRepository {


    final static String URL = "jdbc:postgresql://54.93.65.5:5432/QA6_Teodora";
    final static String USERNAME = "fasttrackit_dev";
    final static String PASSWORD = "fasttrackit_dev";

    public static void main(String args[]) {
        Book book = new Book("teo","teo1",1234,1990);

        try {
            insert(book);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insert(Book book) throws ClassNotFoundException, SQLException {
        // 1. load the driver
        Class.forName("org.postgresql.Driver");

        // 2. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO BookEpedia( author, title, isbn, publishingyear) VALUES (?,?, ?, ?)");
        pSt.setString(1, book.getAuthor());
        pSt.setString(2, book.getTitle());
        pSt.setInt(3, book.getIsbn());
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
        ResultSet rs = st.executeQuery("SELECT id, author, title, isbn, publishingyear FROM BookEpedia");

        // 5. iterate the result set and print the values
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book(
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getInt("isbn"),
                    rs.getInt("publishingyear")

            );
            book.setId(rs.getLong("id"));
            books.add(book);
        }


        // 6. close the objects
        rs.close();
        st.close();
        conn.close();
        return books;
    }

}

