package edu.unbosque.JPATutorial.servlets.Edition;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModfyEdicionServlet", value = "/modify-Edition")
public class ModfyEdicionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer edition_id = Integer.parseInt(request.getParameter("edition_id"));
        String descripcion = request.getParameter("descripcion");
        Integer year = Integer.parseInt(request.getParameter("year"));
        Integer bookID = Integer.parseInt(request.getParameter("book_id"));

        EditionService editionService = new EditionService();
        editionService.mjodifyEdition(edition_id,descripcion,year);

        response.sendRedirect("./Edition.jsp");

    }

}
