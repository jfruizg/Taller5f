package edu.unbosque.JPATutorial.servlets.Customer;

import edu.unbosque.JPATutorial.services.CustomerServices;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "modifyCustomerServlet", value = "/modify-customer")
public class modifyCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");
        String nombre = request.getParameter("name");
        String apellido = request.getParameter("apellido");
        String sexo = request.getParameter("sexo");
        String años = request.getParameter("años");

        CustomerServices customerServices = new CustomerServices();
        customerServices.modifyCustomer(email,nombre,apellido,sexo,años);

        response.sendRedirect("./customer.jsp");
    }
}
