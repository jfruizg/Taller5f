package edu.unbosque.JPATutorial.servlets.Book;

import edu.unbosque.JPATutorial.jpa.entities.Edition;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "cretateBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        Integer authorId = Integer.parseInt(request.getParameter("author_id"));
        String genre = request.getParameter("genre");
        String descripcion = request.getParameter("descripcion");
        String year = request.getParameter("year");
        Integer id =Integer.parseInt(request.getParameter("id"));



        BookService bookService = new BookService();
        bookService.saveBook(title, isbn, authorId);

        EditionService editionService = new EditionService();
        editionService.saveEdition(id,descripcion,null,genre);

        response.sendRedirect("./index.jsp");

    }

}
