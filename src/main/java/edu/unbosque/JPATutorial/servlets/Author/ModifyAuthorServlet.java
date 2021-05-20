package edu.unbosque.JPATutorial.servlets.Author;

import edu.unbosque.JPATutorial.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyAuthorServlet", value = "/modify-Author")
public class ModifyAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer authorId = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        String country = request.getParameter("country");

        AuthorService authorService = new AuthorService();
        authorService.modifyAuthor(authorId,name,country);

        response.sendRedirect("./author.jsp");
    }

}
