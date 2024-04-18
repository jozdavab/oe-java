package oe.lab12.lab12_20240501_examspring.model;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private static StudentRepository instance;
    private final List<Student> students;

    private StudentRepository() {
        this.students = new ArrayList<>(3);
        students.add(new Student("neptun1", "pass1", "Test student1"));
        students.add(new Student("neptun2", "pass2", "Test student2"));
        students.add(new Student("admin", "admin", "Administrator"));
    }

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentByNeptunCode(String neptun) {
        return students.stream().filter(s -> s.getNeptunCode().equals(neptun)).findFirst().orElse(null);
    }

    public boolean removeStudent(String neptun) {
        Student stud = students.stream().filter(s -> s.getNeptunCode().equals(neptun)).findFirst().orElse(null);
        if (stud != null) {
            students.remove((stud));
            return true;
        }
        return false;
    }
}