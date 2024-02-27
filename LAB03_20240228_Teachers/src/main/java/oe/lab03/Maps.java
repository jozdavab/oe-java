package oe.lab03;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {

        // Key value pairs
        // If key is not primitive(wrapper) it must override equals/hashcode!
        // Value can be anything, even a new collection or a map.
        Map<String, Student> studensMap = new HashMap<>();

        Student s = new Student("ABC123", "name1", 3);
        Student s2 = new Student("DEF456", "name2", 5);

        // Use neptun as keys.
        studensMap.put(s.getNeptun(), s);
        studensMap.put(s2.getNeptun(), s2);

        // This will override the previously stored student with the same key.
        studensMap.put("ABC123", new Student("ABC123", "name3", 2));

        // We can iterate over the keys.
        for (String key : studensMap.keySet()) {
            System.out.println(key);
        }

        // We can iterate over the values.
        for (Student value : studensMap.values()) {
            System.out.println(value);
        }

        boolean isThereAKeyLikeThat = studensMap.containsKey("DEF456");

        // This returns null if key is not found.
        Student some = studensMap.get("ABC123");

        // Deleting key and removing instance.
        studensMap.remove("ABC123");
    }
}
