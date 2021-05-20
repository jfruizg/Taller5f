package edu.unbosque.JPATutorial.servlets.Libraries;

import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modifyLibraryServlet", value = "/modify-Library")
public class ModifyLibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name_replaced");

        LibraryService libraryService = new LibraryService();
        libraryService.modifyLibrary(id,name);

        response.sendRedirect("./Library.jsp");

    }
}
