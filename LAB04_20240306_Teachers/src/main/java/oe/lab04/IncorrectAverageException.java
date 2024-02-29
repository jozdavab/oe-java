package oe.lab04;

// Custom exception, derived from the base Exception class.
public class IncorrectAverageException extends Exception {

    // A field for storing the value that caused the exception.
    private final double incorrectAverage;  // Can be final, as there is no setter defined for the field.

    // Constructor. ALT + INSERT to auto generate.
    public IncorrectAverageException(double incorrectAverage) {
        this.incorrectAverage = incorrectAverage;
    }

    // Getter. ALT + INSERT to auto generate.
    public double getIncorrectAverage() {
        return incorrectAverage;
    }
}