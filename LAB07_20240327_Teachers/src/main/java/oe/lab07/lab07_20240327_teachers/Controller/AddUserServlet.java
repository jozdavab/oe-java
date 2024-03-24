package oe.lab07.lab07_20240327_teachers.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oe.lab07.lab07_20240327_teachers.Model.User;
import oe.lab07.lab07_20240327_teachers.Model.UserRepository;

import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String address = request.getParameter("address");
        String fullName = request.getParameter("fullname");
        // Note: Input validation should take place here.

        User user = new User(username, password, fullName, address);
        UserRepository.getInstance().addUser(user);

        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
    }
}