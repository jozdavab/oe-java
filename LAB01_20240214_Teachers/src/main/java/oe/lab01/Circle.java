package oe.lab01;

public class Circle implements Shape {
    private double radius;  //Default visibility is package-private! You have to set private visibility explicitly.

    //Alt + Insert to autogenerate
    public double getRadius() {
        return radius;
    }

    //Alt + Insert to autogenerate
    public void setRadius(double radius) {
        this.radius = radius;
    }

    //Alt + Insert to autogenerate
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override   //Annotation: metadata for the compiler; doesn't add extra function to the program, not mandatory
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override   //Annotation: metadata for the compiler; doesn't add extra function to the program, not mandatory
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }
}
