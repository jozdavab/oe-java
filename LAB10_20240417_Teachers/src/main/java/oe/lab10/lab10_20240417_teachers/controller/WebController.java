package oe.lab10.lab10_20240417_teachers.controller;

import oe.lab10.lab10_20240417_teachers.model.Topping;
import oe.lab10.lab10_20240417_teachers.model.ToppingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import oe.lab10.lab10_20240417_teachers.model.Pizza;


@Controller
@SessionAttributes("pizza")
public class WebController {

    @Autowired
    private ToppingsRepository availableToppings;

    @ModelAttribute("pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @RequestMapping("/")
    public String startPage() {
        return "index.jsp";
    }

    @PostMapping("/neworder")
    public String pizzaPage(@SessionAttribute("pizza") Pizza pizza, @RequestParam("size") String size) {
        pizza.setSize(Integer.parseInt(size));
        return "PizzaCreator.jsp";
    }

    @GetMapping("/add")
    public String addTopping(@SessionAttribute("pizza") Pizza pizza, @RequestParam("name") String name, Model model) {
        Topping t = availableToppings.getTopping(name);
        if (t != null) {
            pizza.addTopping(t);
            model.addAttribute("message", "Topping added.");
        }
        return "PizzaCreator.jsp";
    }

    @GetMapping("/remove")
    public String removeTopping(@SessionAttribute("pizza") Pizza pizza, @RequestParam("name") String name, Model model) {
        Topping t = availableToppings.getTopping(name);
        if (t != null) {
            pizza.removeTopping(t);
            model.addAttribute("message", "Topping removed.");
        }
        return "PizzaCreator.jsp";
    }

    @PostMapping("/summary")
    public String summaryPage() {
        return "Summary.jsp";
    }
}

