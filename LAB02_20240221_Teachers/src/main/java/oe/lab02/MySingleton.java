package oe.lab02;

import java.util.ArrayList;

public class MySingleton {

    // Static field to store an instance of MySingleton
    private static MySingleton instance;

    // Some example data in the singleton class.
    private final ArrayList<Person> personList;

    // CTOR is private so cannot be used for creating new instances outside this class.
    private MySingleton() {
        personList = new ArrayList<>();
    }

    // Only this method can be used to create (or get) an instance.
    // Static!
    public static MySingleton getInstance() {
        if (instance == null)
            instance = new MySingleton();
        return instance;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }
}