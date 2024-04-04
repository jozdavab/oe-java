package oe.lab09.lab09_20240410_teachers.Controller;

import jakarta.servlet.http.HttpSession;
import oe.lab09.lab09_20240410_teachers.Model.User;
import oe.lab09.lab09_20240410_teachers.Model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// 1. IntelliJ Ultimate -> new project -> Spring Initializr
// 2. Type: Maven && Language: Java && Packaging: War
// 3. Go to next page, search for "Spring Web" dependency and add it to project.
// 4. Create webapp folder under main.
// 5. In pom.xml add dependency for tomcat-embed-jasper.
// 6. Start application. Check content in browser.

@Controller
public class WebController {

    @GetMapping("/")
    public String startPage() {
        return "index.jsp";
    }

    @PostMapping("/login")
    public String userLogin(HttpSession session, Model model, @RequestParam("username") String name,
                            @RequestParam("password") String pw) {
        User user = UserRepository.getInstance().findUser(name);
        if (user != null) {
            if (user.getPassword().equals(pw)) {
                session.setAttribute("user", user);
                return "MainPage.jsp";
            } else {
                return "redirect:/incorrect_password.html";
            }
        } else {
            model.addAttribute("user", new User(name, "", "", ""));
            return "Registration.jsp";
        }
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User u, HttpSession session) {
        UserRepository.getInstance().addUser(u);
        session.setAttribute("user", u);
        return "MainPage.jsp";
    }
}