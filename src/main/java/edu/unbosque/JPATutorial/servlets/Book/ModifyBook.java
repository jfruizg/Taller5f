package edu.unbosque.JPATutorial.servlets.Book;
import com.google.gson.Gson;
import edu.unbosque.JPATutorial.jpa.entities.Book;
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

@WebServlet(name = "deleteBookServlet" , value = "/modify-Book")
public class ModifyBook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("id"));

        BookService bookService = new BookService();
        bookService.modifyBook(authorId,null,null);

        response.sendRedirect("./index.jsp");
    }

}

