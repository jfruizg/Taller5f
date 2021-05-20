package edu.unbosque.JPATutorial.servlets.Edition;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAuthorServlet", value = "/delete-Author")
public class DeleteEdition extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer editionId = Integer.parseInt(request.getParameter("edition_id"));

        EditionService editionService = new EditionService();
        editionService.deleteEdition(editionId);

        response.sendRedirect("./Edition.jsp");

    }

}
