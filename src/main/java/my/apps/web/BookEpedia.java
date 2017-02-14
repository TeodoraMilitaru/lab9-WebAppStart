package my.apps.web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.TitledBorder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/someServlet")
public class BookEpedia extends HttpServlet {

    private int counter;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        counter++;

        //get input as string
        String Author = request.getParameter("author");
        String Title = request.getParameter("title");
        String ISBN = request.getParameter("isbn");
        Integer PublishingYear = Integer.valueOf(request.getParameter("publishing year"));

        System.out.println(Author + Title + PublishingYear);
        // write results to response
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h2>BookEpedia </h2>");
        out.println("author - <b>" + Author + "</b><br/>");
        out.println("title - <b>" + Title + "</b><br/>");
        out.println("isbn - <b>" + ISBN + "</b><br/>");
        out.println("publishingyear - <b>" + PublishingYear + "</b><br/>");
        out.println("<a href='/'>Go Back</a>");

        // finished writing, send to browser
        out.close();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        counter++;
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<head>");
        out.println("<title> Get count </title>");
        out.println("</head>");

        out.println("<h2>Get count</h2>");
        out.println(counter);
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