package oe.lab08.lab08_20240403_teachers.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oe.lab08.lab08_20240403_teachers.Model.Pizza;

import java.io.IOException;

@WebServlet(name = "neworder", urlPatterns = {"/neworder"})
public class NewOrderServlet extends HttpServlet {

    // Calling this from both POST and GET so behavior is the same for both.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sizeParameter = request.getParameter("size");
        // Note: Input validation should take place here.
        int size = Integer.parseInt(sizeParameter);
        Pizza newpizza = new Pizza(size);
        request.getSession().setAttribute("pizza", newpizza);

        // Redirection to the servlet instead of the page, so the application scope data will always be created.
        request.getRequestDispatcher("managetoppings").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}