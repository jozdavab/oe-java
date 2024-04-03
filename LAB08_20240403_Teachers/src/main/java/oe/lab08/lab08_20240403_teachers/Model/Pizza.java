package oe.lab08.lab08_20240403_teachers.Model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final int size;
    private final List<Topping> toppings;

    public Pizza(int size) {
        this.size = size;
        toppings = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping t) {
        toppings.add(t);
    }

    public void removeTopping(Topping t) {
        toppings.remove(t);
    }

    public int totalPrice() {
        int price = size * 50; // Base price is proportional to the size.

        for (Topping topping : toppings) {
            price += topping.getPrice();
        }
        return price;
    }
}
