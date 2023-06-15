package lesson3.tasks;

import java.util.Collections;
import java.util.Iterator;

public class StudentGroupService {
    private final StudentGroup group;

    public StudentGroupService(StudentGroup group) {
        this.group = group;
    }

    public void printAllStudents() {
        for (Student student : group) {
            System.out.println(student);
        }
    }

    public void removeStudentByName(String name) {
        Iterator<Student> iterator = group.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name)) {
                iterator.remove();
            }
        }
    }

    public void sortStudents() {
        Collections.sort(group.getStudents());
    }

    public void sortStudentsByFamilyName() {
        group.getStudents().sort(new StudentComparator());
    }
}
