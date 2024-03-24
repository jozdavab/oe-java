package oe.lab07.lab07_20240327_teachers.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oe.lab07.lab07_20240327_teachers.Model.User;
import oe.lab07.lab07_20240327_teachers.Model.UserRepository;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    // Notice that no html is present here, only redirections to the proper pages.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        // Note: Input validation should take place here.

        User user = UserRepository.getInstance().findUser(username);
        if (user != null) { // if user is found in repository (existing user)
            if (user.isPasswordCorrect(password)) { // and password is correct
                // store reference of user object in session scope
                request.getSession().setAttribute("user", user);
                // and forward request to the main page
                request.getRequestDispatcher("MainPage.jsp").forward(request, response);
            } else { // existing user, wrong password
                // forward to error page
                request.getRequestDispatcher("incorrect_password.html").forward(request, response);
            }
        } else { // user not found in repository (new user)
            // forward to registration page
            request.getRequestDispatcher("Registration.jsp").forward(request, response);
        }
    }
}