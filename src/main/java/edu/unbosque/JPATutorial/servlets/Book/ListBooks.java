package edu.unbosque.JPATutorial.servlets.Book;
import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.servlets.pojos.AuthorPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "ListBooks", value = "/List-books")
public class ListBooks extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        BookService bookService = new BookService();
        List<BookPOJO> books = bookService.listBooks();

        String booksJsonString = new Gson().toJson(books);

        PrintWriter out = response.getWriter();
        out.println(booksJsonString);
        out.flush();
    }


}
