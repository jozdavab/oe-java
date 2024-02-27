package oe.lab03;

public class Student implements Comparable {
    private String neptun;
    private String name;
    private float avg;

    public Student() {
    }

    public Student(String neptun, String name, float avg) {
        this.neptun = neptun;
        this.name = name;
        this.avg = avg;
    }

    public String getNeptun() {
        return neptun;
    }

    public void setNeptun(String neptun) {
        this.neptun = neptun;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "neptun='" + neptun + '\'' +
                ", name='" + name + '\'' +
                ", avg=" + avg +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        // Ordering by name, using the built in implementation of compareTo.
        return name.compareTo(((Student) o).name);
    }

    @Override
    public boolean equals(Object obj) {
        // Equality by reference
        if (obj == this) return true;
        // Different type
        if (!(obj instanceof Student)) return false;

        Student other = (Student) obj;
        return (this.neptun == null && other.neptun == null) || this.neptun.equals(other.neptun);
    }

    @Override
    public int hashCode() {
        return neptun.hashCode();
    }
}
