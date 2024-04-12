package oe.lab10.lab10_20240417_teachers.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int size;
    private final List<Topping> toppings;

    public Pizza() {
        toppings = new ArrayList<>();
    }

    public Pizza(int size) {
        this();
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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