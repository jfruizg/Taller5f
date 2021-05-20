package edu.unbosque.JPATutorial.servlets.Edition;

import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteEditionSerlvet", value = "/creat-edicion")
public class CreateEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer edition_id = Integer.parseInt(request.getParameter("edition_id"));
        String descripcion = request.getParameter("descripcion");
        Integer year = Integer.parseInt(request.getParameter("year"));



        EditionService editionService = new EditionService();
        editionService.saveEdition(edition_id,descripcion,year);

        response.sendRedirect("./Edition.jsp");

    }

}
