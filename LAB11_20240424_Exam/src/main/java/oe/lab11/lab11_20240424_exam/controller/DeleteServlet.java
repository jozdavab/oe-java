package oe.lab11.lab11_20240424_exam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oe.lab11.lab11_20240424_exam.model.StudentRepository;

import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String neptun = request.getParameter("neptun");
        StudentRepository.getInstance().removeStudent(neptun);
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }
}