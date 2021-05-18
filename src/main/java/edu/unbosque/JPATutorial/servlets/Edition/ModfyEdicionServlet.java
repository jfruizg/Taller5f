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

        Integer editionId = Integer.parseInt(request.getParameter("editionId"));

        EditionService editionService = new EditionService();
        editionService.modifyBook(editionId,null);

        response.sendRedirect("./index.jsp");
    }

}