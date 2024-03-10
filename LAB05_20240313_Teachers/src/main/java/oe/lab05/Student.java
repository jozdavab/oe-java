package oe.lab05;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement // For XML serialization
public class Student {
    private String name;
    private float average;
    private int age;

    public Student() {
        // Most libraries need an Empty ctor + getter setters for fields to work properly.
    }

    public Student(String name, float average, int age) {
        this.name = name;
        this.average = average;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "\t" + average + "\t" + age;
    }
}