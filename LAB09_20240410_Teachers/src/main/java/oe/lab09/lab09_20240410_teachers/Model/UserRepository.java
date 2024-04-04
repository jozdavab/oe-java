package oe.lab09.lab09_20240410_teachers.Model;

import java.util.ArrayList;
import java.util.List;

// Question: Instead of a singleton pattern repository, what scope could we use in our controllers?
public class UserRepository {

    //Static field to store an instance of UserRepository
    private static UserRepository instance;
    private List<User> users;
    // ALTERNATIVE solution: ConcurrentHashMap instead of List (Concurrent because multiple users can access it the same time)
    // ALTERNATIVE: private ConcurrentHashMap<String, User> usersMap;

    // Only this method can be used to create (or get) an instance.
    // Static!
    public static UserRepository getInstance() {
        if (instance == null)
            instance = new UserRepository();
        return instance;
    }

    // CTOR is private so cannot be used for creating new instances outside this class.
    private UserRepository() {
        users = new ArrayList<>();
        // ALTERNATIVE: usersMap= new ConcurrentHashMap<>();
        addUser(new User("test", "test", "Tim Test", "Middle of Nowhere"));
    }

    // Methods for the repository:

    public void addUser(User newUser) {
        users.add(newUser);
        // ALTERNATIVE: usersMap.putIfAbsent(newUser.getUsername(), newUser);
    }

    public User findUser(String username) {
        return users.stream()
                .filter(x -> x.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
        // ALTERNATIVE: return usersMap.get(username);
    }
}