package oe.lab02;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        //1. ArrayList
        //ArrayList<int> numbers = new ArrayList<>();   Compile error, ArrayList is not working with primitives.
        ArrayList<Integer> numbers = new ArrayList<>(10); // ArrayList with initial capacity of 10
        for (int i = 9; i >= 0; i--) {
            numbers.add(i);
        }
        for (int i : numbers) {
            System.out.println(i);
        }
        Collections.sort(numbers);
        for (int i : numbers) {
            System.out.println(i);
        }


        //2. Singleton
        MySingleton ms = MySingleton.getInstance();

        Person p1 = new Person();
        Student st1 = new Student("Adam", "AAA111", 5.0f);
        Student st2 = new Student("Bela", "BBB222", 3.0f);
        ms.getPersonList().add(p1);
        ms.getPersonList().add(st1);
        ms.getPersonList().add(st2);

        //3. Type check

        // Print out the students in the list.
        // FORE TAB TAB to autogenerate
        for (Person p : ms.getPersonList()) {
            if (p instanceof Student) {
                System.out.println(p);
            }
        }
    }
}