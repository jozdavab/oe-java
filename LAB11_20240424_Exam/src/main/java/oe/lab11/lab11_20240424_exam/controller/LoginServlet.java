package oe.lab11.lab11_20240424_exam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oe.lab11.lab11_20240424_exam.model.Student;
import oe.lab11.lab11_20240424_exam.model.StudentRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String neptun = request.getParameter("neptun");
        String password = request.getParameter("password");

        Student student = StudentRepository.getInstance().getStudentByNeptunCode(neptun);
        if (student != null && student.getPassword().equals(password)) {
            request.getSession().setAttribute("student", student);
            if (student.getNeptunCode().equals("admin")) {
                request.getRequestDispatcher("adminPage.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("mainPage.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}