import java.util.*;


class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " | Marks: " + marks;
    }
}

public class PartB {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Riya", 82),
            new Student("Aman", 67),
            new Student("Vikram", 91),
            new Student("Sanya", 74),
            new Student("Neha", 89)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
