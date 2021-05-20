package edu.unbosque.JPATutorial.servlets.Libraries;

import edu.unbosque.JPATutorial.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.Inet4Address;

@WebServlet(name = "deleteLibraryServlet", value = "/delete-library")
public class DeleteLibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        Integer name = Integer.parseInt(request.getParameter("id"));

        LibraryService libraryService = new LibraryService();
        libraryService.deleteLibrary(name);

        response.sendRedirect("./Library.jsp");

    }
}
