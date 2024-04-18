package oe.lab12.lab12_20240501_examspring.controller;


import jakarta.servlet.http.HttpSession;
import oe.lab12.lab12_20240501_examspring.model.Student;
import oe.lab12.lab12_20240501_examspring.model.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {

    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }

    @PostMapping("/login")
    public String login(String neptun, String password, HttpSession session) {
        Student student = StudentRepository.getInstance().getStudentByNeptunCode(neptun);
        if (student != null && student.getPassword().equals(password)) {
            session.setAttribute("student", student);
            if (student.getNeptunCode().equals("admin")) {
                setFilteredStudentList(session);
                return "adminPage.jsp";
            } else {
                return "mainPage.jsp";
            }
        } else {
            return "index.jsp";
        }
    }

    @GetMapping("/delete")
    public String delete(String neptun, HttpSession session) {
        StudentRepository.getInstance().removeStudent(neptun);
        setFilteredStudentList(session);
        return "adminPage.jsp";
    }

    private void setFilteredStudentList(HttpSession session) {
        List<Student> students = StudentRepository
                .getInstance()
                .getStudents()
                .stream()
                .filter(s -> !s.getNeptunCode().equals("admin"))
                .toList();

        session.setAttribute("students", students);
    }
}