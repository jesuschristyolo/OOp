package lesson3.tasks;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {
    private final Long id;
    private final String name;

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
