package oe.lab04;

public class Student implements Comparable {
    private final String name; // As there is no setter for this field, and we only assign value at the ctor, this can be final.
    private float average;

    // Constructor. ALT + INSERT to auto generate.
    public Student(String name, float average) throws IncorrectAverageException {
        this.name = name;
        setAverage(average); // We call the setter, instead of directly accessing the field, so the value is checked.
    }

    // Getter. ALT + INSERT to auto generate.
    public String getName() {
        return name;
    }

    // Getter. ALT + INSERT to auto generate.
    public float getAverage() {
        return average;
    }

    // Setter. ALT + INSERT to auto generate.
    // We add the exception to the function signature, so anyone who calls the function will know about it, and handle it.
    public void setAverage(float average) throws IncorrectAverageException {
        //If average is incorrect, we throw a custom exception
        if (average < 0 || average > 5) {
            throw new IncorrectAverageException(average);
        }
        this.average = average; // This line is reached only if no exception is thrown.
    }

    // ToString for pretty printing. ALT + INSERT to auto generate.
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", average=" + average +
                '}';
    }

    // Implementing the comparable interface, so we can store Student instances in the treeset (which is an ordered collection)
    // ALT + INSERT to auto generate after putting the "implements comparable" on the class.
    @Override
    public int compareTo(Object o) {

        // Using the float class built in comparator
        return Float.compare(this.average, ((Student) o).average);

        // Or we could write our own logic like this (but this can be faulty as we didn't handle NaNs here):
        /*
        if (this.average < ((Student) o).average) {
            return -1;
        } else if (this.average > ((Student) o).average) {
            return 1;
        } else {
            return 0;
        }*/
    }
}