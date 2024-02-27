package oe.lab03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lists {

    public static void main(String[] args) {

        // Collections cant store primitives!
        //ArrayList<int> numberList = new ArrayList<>();

        // <> diamond operator. Compiler will find the matching type. (Student)
        ArrayList<Integer> numberList = new ArrayList<>();

        // Easier to change the implementation later this way.
        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);                     // Autoboxing
        numbers.add(2);
        int size = numbers.size();          // Length of list.
        numbers.set(0, 100);                // Replaces item at index.
        int item = numbers.get(0);          // Getting item by index
        int index = numbers.indexOf(100);   // Gives back index of item. Gives back -1 if item is not in collection.

        numbers.remove(0);            // Removing item by index!
        numbers.remove((Integer) 2);        // Removing item by value!

        // This works to, but it uses raw types. Avoid if possible.
        List listRaw = new ArrayList();
        listRaw.add("string");
        String itemString = (String) listRaw.get(0);    // Casting is needed because of raw list initialization!

        // Adding some data to the list
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        // Built in functions for common operations.
        Collections.shuffle(numbers);
        Collections.sort(numbers);
        Collections.reverse(numbers);

        // List of custom type. Student must override equals/hashcode for contains/remove.
        List<Student> studs = new ArrayList<>();
        studs.add(new Student("neptun1", "name1", 5));
        studs.add(new Student("neptun1", "name2", 3));

        Collections.sort(studs); // Only works if Student is comparable!!
        Collections.sort(studs, Comparator.comparing(Student::getName)); // Sort by name instead of student's own impl.
    }
}
