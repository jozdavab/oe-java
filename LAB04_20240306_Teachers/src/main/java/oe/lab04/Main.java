package oe.lab04;

import java.util.*;

public class Main {

    // main tab tab to autogenerate.
    public static void main(String[] args) {

        // Create student instances! Store them in a collection!
        // (The try-catch block was added later, as part of the next exercises)
        ArrayList<Student> students = new ArrayList<>();
        try {
            students.add(new Student("A", 3.5f)); //f means floating point
            students.add(new Student("B", 1.3f));
            students.add(new Student("C", 2.5f));
            students.add(new Student("D", 5.5f));
            students.add(new Student("E", 4.0f));
            students.add(new Student("F", 3.6f));
            students.add(new Student("G", 0.9f));
        } catch (IncorrectAverageException e) {
            System.out.printf("Invalid Average: %.2f%n", e.getIncorrectAverage());
        }

        // Print out students to the console! User iterative for! Override ToString() for nice visualisation.
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        // Print out students to the console! Use foreach! Override ToString() for nice visualisation.
        for (Student student : students) {
            System.out.println(student);
        }

        // Try to modify an average to an invalid value. Handle the exception when it is thrown.
        try {
            students.get(0).setAverage(3.8f);             // This will be OK.
            students.get(1).setAverage(-0.2f);            // This will throw an exception
        } catch (IncorrectAverageException ex) {
            // We only catch IncorrectAverageExceptions here
            System.out.printf("Invalid Average: %.2f%n", ex.getIncorrectAverage());
        } catch (Exception ex) {
            // We could catch all kinds of exceptions here. Not recommended!
            ex.printStackTrace();
        } catch (Throwable th) {
            // We could catch all kinds of throwables (exceptions, errors) here. Not recommended!
            th.printStackTrace();
        }


        // Stream API exercises:

        // Find the Student with best average without StreamAPI:
        int maxi = 0;
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverage() > students.get(maxi).getAverage()) {
                maxi = i;
            }
        }
        System.out.println("Student with best avg: " + students.get(maxi));

        // Find the Student with best average with StreamAPI:
        Student best2 = students
                .stream()
                .max(Comparator.comparing(s -> s.getAverage()))
                .get();

        System.out.println("Student with best avg: " + best2);

        // Find the Student with best average with StreamAPI alternatively:
        // Calling .get() on an optional may result in exceptions. You can instead
        //  A/ Use .orElse() to provide an alternative if optional is not there
        //  B/ Check with .IsThere()
        Student best3 = students
                .stream()
                .max(Comparator.comparing(s -> s.getAverage()))
                .orElse(null); //Gives back null if max is not giving back student.

        if (best3 != null) {
            System.out.println("Best student: " + best3);
        } else {
            System.out.println("Something is wrong. Perhaps <students> collection is empty?");
        }

        // Get Average of Student B without StreamAPI:
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getName().equals("B")) {
                System.out.println("Average of Student B: " + students.get(i).getAverage());
            }
        }

        // Get Average of Student B with StreamAPI:
        float bAVG = students
                .stream()
                .filter(s -> s.getName().equals("B"))
                .findFirst()
                .get()
                .getAverage();
        System.out.println("Average of Student B: " + bAVG);


        // Get names of students who have an average less than 2.0 without StreamAPI:
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverage() < 2.0f) {
                System.out.println(students.get(i).getName());
            }
        }

        // Get names of students who have an average less than 2.0 with StreamAPI:
        students
                .stream()
                .filter(s -> s.getAverage() < 2)
                .map(s -> s.getName())
                .forEach(s -> System.out.println(s));

        // Get names of students who have an average less than 2.0 with StreamAPI with alternative syntax:
        students
                .stream()
                .filter(s -> s.getAverage() < 2)
                .map(Student::getName)
                .forEach(System.out::println);


        // Get names of students who have an average less than 2.0 with StreamAPI alternatively, storing the students:
        String[] failingStudentNames = students
                .stream()
                .filter(s -> s.getAverage() < 2)
                .map(s -> s.getName())
                .toArray(String[]::new);

        for (String name : failingStudentNames) {
            System.out.println(name);
        }

        // TreeSet
        TreeSet<Student> studentsTreeSet = new TreeSet();
        studentsTreeSet.addAll(students);  // Works because student implements Comparable. Adds all students from the arraylist to the treeset.


        // Get students with >=3 average naivly
        for (Student student : studentsTreeSet) {
            if (student.getAverage() >= 3) {
                System.out.println(student);
            }
        }

        // Get students with >=3 average using tailSet.
        try {
            for (Student student : studentsTreeSet.tailSet(new Student("", 3.0f))) {
                System.out.println(student);
            }
        } catch (IncorrectAverageException e) {
            System.out.println("We should never reach this.");
        }

        // Get students with >=3 average using streamAPI
        studentsTreeSet
                .stream()
                .filter(s -> s.getAverage() >= 3)
                .forEach(System.out::println); // Method reference. Compiler will guess and match the parameter

    }
}