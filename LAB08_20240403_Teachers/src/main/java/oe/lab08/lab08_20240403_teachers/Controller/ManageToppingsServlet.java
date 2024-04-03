package oe.lab08.lab08_20240403_teachers.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import oe.lab08.lab08_20240403_teachers.Model.Pizza;
import oe.lab08.lab08_20240403_teachers.Model.Topping;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "managetoppings", urlPatterns = {"/managetoppings"})
public class ManageToppingsServlet extends HttpServlet {

    // Calling this from both POST and GET so behavior is the same for both.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Null check prevents the recreation of application scope data.
        // Could use singleton repository instead.
        if (getServletContext().getAttribute("availableToppings") == null) {
            ArrayList<Topping> toppings = new ArrayList();
            toppings.add(new Topping("mushrooms", 100));
            toppings.add(new Topping("tomatoes", 150));
            toppings.add(new Topping("beans", 150));
            toppings.add(new Topping("pineapple", 200));
            toppings.add(new Topping("corn", 100));
            toppings.add(new Topping("cheddar cheese", 300));
            toppings.add(new Topping("mozzarella cheese", 200));
            toppings.add(new Topping("parmesan cheese", 300));

            getServletContext().setAttribute("availableToppings", toppings);
        }
        Pizza pizza = (Pizza) request.getSession().getAttribute("pizza");
        ArrayList<Topping> toppings = (ArrayList<Topping>) getServletContext().getAttribute("availableToppings");

        // If we navigated here with this parameter, we should handle the new topping.
        if (request.getParameter("add") != null) {
            String newToppingName = request.getParameter("add");
            Topping t = toppings.stream()
                    .filter(topping -> topping.getName().equals(newToppingName))
                    .findFirst()
                    .orElse(null);
            if (t != null) {
                pizza.addTopping(t);
                request.setAttribute("message", "Topping added.");
            }
        }
        // If we navigated here with this parameter, we should handle the topping removal.
        if (request.getParameter("remove") != null) {
            String oldToppingName = request.getParameter("remove");
            Topping t = toppings.stream()
                    .filter(topping -> topping.getName().equals(oldToppingName))
                    .findFirst()
                    .orElse(null);
            if (t != null) {
                pizza.removeTopping(t);
                request.setAttribute("message", "Topping removed.");
            }
        }
        // Forward to the creator page
        request.getRequestDispatcher("PizzaCreator.jsp").forward(request, response);
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