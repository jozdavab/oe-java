package oe.lab02;

import java.io.Serializable;

// This is a Java bean: Public default CTOR, private fields with G/S methods, Serializable.
public class Student extends Person implements Serializable {

    private String name, neptun;    // Default visibility is package-private! You have to set private visibility explicitly.
    private float average;          // Default visibility is package-private! You have to set private visibility explicitly.

    // default constructor
    public Student() {
    }

    // full param constructor
    public Student(String name, String neptun, float average) {
        this.name = name;
        this.neptun = neptun;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeptun() {
        return neptun;
    }

    public void setNeptun(String neptun) {
        this.neptun = neptun;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    // Annotation: metadata for the compiler; doesn't add extra function to the program, not mandatory
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", neptun='" + neptun + '\'' +
                ", average=" + average +
                '}';
    }

    // You can define an entry point to your application anywhere.
    public static void main(String[] args) {
        Student s = new Student("name", "neptun", 1.0f);
        System.out.println(s);
    }

}