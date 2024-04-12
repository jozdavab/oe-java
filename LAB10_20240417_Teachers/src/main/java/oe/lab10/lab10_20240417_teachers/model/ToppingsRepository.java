package oe.lab10.lab10_20240417_teachers.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;
import java.util.HashMap;

@Component
@ApplicationScope
public class ToppingsRepository {

    private final HashMap<String, Topping> toppings;

    public ToppingsRepository() {
        toppings = new HashMap<>();
        toppings.put("mushrooms", new Topping("mushrooms", 100));
        toppings.put("tomatoes", new Topping("tomatoes", 150));
        toppings.put("beans", new Topping("beans", 150));
        toppings.put("pineapple", new Topping("pineapple", 200));
        toppings.put("corn", new Topping("corn", 100));
        toppings.put("cheddar cheese", new Topping("cheddar cheese", 300));
        toppings.put("mozzarella cheese", new Topping("mozzarella cheese", 200));
        toppings.put("parmesan cheese", new Topping("parmesan cheese", 300));
    }

    public Collection<Topping> getToppings() {
        return toppings.values();
    }

    public Topping getTopping(String name) {
        return toppings.get(name);
    }
}
