package oe.lab06.lab06_20240320_teachers;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 0. Download and unzip/install a tomcat server. (https://tomcat.apache.org/download-10.cgi)
// 1. IntelliJ Ultimate -> new project -> Java Enterprise || Java EE || Jakarta EE template
// 2. Project template: Web application, NOT REST Service!
// 3. Application server: - new - Tomcat Server (browse the previously installed one)
// 4. Language: Java, Build System: Maven.
// 5. Go to next page, set Version to Jakarta EE 9.X. Create project.
// 6. Put JSP and HTML files under webapp folder.
// 7. Run Tomcat server (build + deploy). Check content in browser.

// 8. Optional. Renaming Webapp. Run -> Edit Configurations. Url: Change webapp name.
// 9. Deployment tab -> Application context: New webapp name.

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        // Will run once on creation.
        message = "Hello World!";
    }

    // HTTP GET will be processed here
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        // Using this approach we create a simple HTML page line by line
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Tax Calculation Results</title>");
        out.println("</head>");
        out.println("<body>");

        String name = request.getParameter("name");
        // Input validation is important. Parameters could be missing || could contain harmful code
        if (name.isEmpty()) {
            name = "Unknown User";
        }
        out.println("<h1>Hello " + name + "!</h1>");

        String salstring = request.getParameter("salary");
        if (!salstring.isEmpty()) {
            int sal = Integer.parseInt(salstring);
            double tax = sal * 0.15;
            out.printf("<p>The income tax for a %d HUF salary is %.2f HUF.</p>%n", sal, tax);
        } else {
            out.println("<p>Salary unknown, tax calculation failed.</p>");
        }

        out.println("<a href=\"index.jsp\">Back to the calculator</a>");
        out.println("</body></html>");
    }

    // HTTP POST will be processed here
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "this will be shown on POST" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        // Will run once on destroy.
    }
}