package lesson3.tasks;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class StudentGroup implements Iterable<Student> {
    private final List<Student> students;

    public StudentGroup() {
        this.students = new ArrayList<>();
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
