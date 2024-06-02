
public class Student implements Comparable<Student> {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Student other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return name;
    }

}
