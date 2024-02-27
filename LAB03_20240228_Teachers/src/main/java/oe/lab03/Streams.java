package oe.lab03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        // 0. Test data
        List<Student> studList = new ArrayList<>();

        // Add some students to the list. Grades between 1-4
        for (int i = 1; i < 10; i++) {
            studList.add(new Student("ABC00" + i, "name" + i, i % 4));
        }

        // Visualise students
        for (Student s : studList) {
            System.out.println(s);
        }

        // 1. Stream basics
        // Every Collection has a .stream() function.
        // Stream pipeline:  stream() --> intermediate() --> intermediate() --> ... --> terminal()

        // Streams are lazy, leaving out terminal() operation won't cause compile error.
        Stream<Student> studentStream = studList.stream();

        // Visualise students using stream

        // Passing a function as a parameter
        studList.stream().forEach((Student item) -> System.out.println(item));

        // Shorter syntax, compiler can guess the type of item
        studList.stream().forEach(item -> System.out.println(item));

        // Even shorter syntax, using method reference.
        studList.stream().forEach(System.out::println);

        // We can work with streams on multiple threads.
        // Can be slower than single threaded approach, because of the overhead of creating/joining threads!
        studList.parallelStream().forEach(System.out::println);


        // 2. Sorting with streams
        // Print sorted students. Only works if Student is Comparable!
        studList.stream().sorted().forEach(System.out::println);


        // 3. Filtering streams
        // Print failing students
        studList.stream().filter(s -> s.getAvg() < 2).forEach(System.out::println);

        // Find student named "name2".
        // Get throws an Exception if no such student is present!
        Student stud = studList.stream().filter(s -> s.getName().equals("name2")).findFirst().get();

        //  OrElse will return null if no such student is present. Can be used for default results.
        Student stud2 = studList.stream().filter(s -> s.getName().equals("name2")).findFirst().orElse(null);

        // Print out student named "name2". If no such student, nothing happens.
        studList.stream().filter(s -> s.getName().equals("name2")).findFirst().ifPresent(System.out::println);

        // Count whose name starts whit "n"
        long count = studList.stream().filter(s -> s.getName().startsWith("n")).count();

        // 4. Mapping (transforming) streams
        // Get avg of students
        List<Float> avg = studList.stream().map(s -> s.getAvg()).toList();

        // Get avg of students with methodreference.
        List<Float> avg2 = studList.stream().map(Student::getAvg).toList();

        //Create a student collection from the names.
        List<String> names = List.of("Adam", "Bob", "Catalin", "Daniel");
        List<Student> studentList = names
                .stream()
                .map(name -> createStudentFromName(name))    // Helper function, so syntax is cleaner.
                .collect(Collectors.toList());              // Collects the elements of the stream to a list.

        // 5. Max
        // Get the best student
        Student best = studList.stream().max(Comparator.comparing(Student::getAvg)).orElse(null);

        // Get the best student alternatively. This will not use the compareTo() defined in Student.
        Student best2 = studList.stream().sorted(Comparator.comparing(Student::getAvg).reversed()).findFirst().orElse(null);
    }

    private static final Random rnd = new Random(); // java.util.Random package

    // This method creates a student with given name, using a random number for average.
    private static Student createStudentFromName(String name) {
        float average = rnd.nextFloat() * 5;
        String neptun = "neptun";   // We shall generate a neptun using some kind of custom logic;
        return new Student(neptun, name, average);
    }
}