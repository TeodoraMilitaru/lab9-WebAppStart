package my.apps.web;
import my.apps.db.BookRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/BookEpedia")
public class BookEpedia extends HttpServlet {

    private int counter;

    private BookRepository bookRepository = new BookRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        //get input as string
        String Author = request.getParameter("author");
        String Title = request.getParameter("title");
        Integer ISBN;
        if (request.getParameter("isbn") != null) {
             ISBN = Integer.parseInt(request.getParameter("isbn"));
        }
        else {
             ISBN = null;
        }
        Integer PublishingYear = Integer.valueOf(request.getParameter("publishingyear"));
        Book book = new Book(Author, Title, ISBN, PublishingYear);


        // write results to response
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<div id='container'>");
        out.println("<h2>BookEpedia </h2>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
        out.println("<b>" + book.toString() +  "</b><br />");

        try {
            out.println("<h3>New book...</h3>");
            bookRepository.insert(book);
            out.println("<b>" + book.toString() +  "</b><br />");
        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e) {
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }
        out.println("</dvi>");



        /*out.println("author - <b>" + book + "</b><br/>");
        out.println("title - <b>" + Title + "</b><br/>");
        out.println("isbn - <b>" + ISBN + "</b><br/>");
        out.println("publishingyear - <b>" + PublishingYear + "</b><br/>");*/

       //out.println("<a href='/'>Go Back</a>");

        addGoBack(out);


        // finished writing, send to browser
        out.close();

    }

    private void addGoBack(PrintWriter out) {
        out.println("<a href='/' id='goBack'>Go Back</a>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<head>");
        //out.println("<title> Get count </title>");
        out.println("<title> Books </title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">");
        out.println("</head>");
/*
        out.println("<h2>Get count</h2>");
        out.println(counter);*/
        try {
            /*out.println("<h2>Get count</h2>");
            out.println(counter);*/
            out.println("<div id='container'>");
            out.println("<h2>All available books</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>#</th>");
            out.println("<th>Author</th>");
            out.println("<th>Title</th>");
            out.println("<th>ISBN</th>");
            out.println("<th>Publishing Year</th");
            out.println("</tr>");



         /*   bookRepository.read();*/
            Integer index = 0;
            List<Book> books = bookRepository.read();
            for (Book book : books) {
                index++;
                out.println("<tr>");
                out.println("<td>"+index.toString()+"</td>");
                out.println("<td>"+book.getAuthor()+"</td>");
                out.println("<td>"+book.getTitle()+"</td>");
                out.println("<td>"+book.getIsbn().toString()+"</td>");
                out.println("<td>"+book.getPublishingyear().toString()+"</td>");
                out.println("</tr>");

            }

            out.println("</table>");


        } catch (ClassNotFoundException e) {
            out.println("<div class='error'><b>Unable initialize database connection<b></div>");
        } catch (SQLException e) {
            out.println("<div class='error'><b>Unable to write to database! " +  e.getMessage() +"<b></div>");
        }
        addGoBack(out);
        out.println("</div>");
        out.close();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init() called. Counter is: " + counter);
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet! Counter is:" + counter);
        super.destroy();
    }
}