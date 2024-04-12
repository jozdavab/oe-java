package oe.lab10.lab10_20240417_teachers.model;

public class Topping {
    private final String name;
    private final int price;

    public Topping(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}