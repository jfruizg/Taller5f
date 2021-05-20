package edu.unbosque.JPATutorial.servlets.Customer;

import edu.unbosque.JPATutorial.services.AuthorService;
import edu.unbosque.JPATutorial.services.CustomerServices;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCustomerServlet", value = "/delete-edicion")
public class DeleteCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String email = request.getParameter("email");

        CustomerServices customerServices = new CustomerServices();
        customerServices.deleteCustomer(email);

        response.sendRedirect("./customer.jsp");
    }

}
