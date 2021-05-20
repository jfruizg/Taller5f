package edu.unbosque.JPATutorial.servlets.Book;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deletBookAuthor", value = "/delete-book")
public class DeleteBook extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");


        Integer bookID = Integer.parseInt(request.getParameter("book_id"));


        BookService bookService = new BookService();
        bookService.deleteBookAuthor(bookID);

        response.sendRedirect("./index.jsp");
    }




}
