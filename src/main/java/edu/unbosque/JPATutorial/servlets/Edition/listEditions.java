package edu.unbosque.JPATutorial.servlets.Edition;

import com.google.gson.Gson;
import edu.unbosque.JPATutorial.services.BookService;
import edu.unbosque.JPATutorial.services.EditionService;
import edu.unbosque.JPATutorial.servlets.pojos.BookPOJO;
import edu.unbosque.JPATutorial.servlets.pojos.EditionPOJO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listEditions", value = "/List-Editions")
public class listEditions extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        EditionService editionService = new EditionService();
        List<EditionPOJO> edition = editionService.listEditions();

        String booksJsonString = new Gson().toJson(edition);

        PrintWriter out = response.getWriter();
        out.println(booksJsonString);
        out.flush();
    }


}
