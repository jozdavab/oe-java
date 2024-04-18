package oe.lab11.lab11_20240424_exam.model;

public class Student {
    private String neptunCode;
    private String password;
    private String name;

    public Student() {
    }

    public Student(String neptunCode, String password, String name) {
        this.neptunCode = neptunCode;
        this.password = password;
        this.name = name;
    }

    public String getNeptunCode() {
        return neptunCode;
    }

    public void setNeptunCode(String neptunCode) {
        this.neptunCode = neptunCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "neptunCode='" + neptunCode + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}