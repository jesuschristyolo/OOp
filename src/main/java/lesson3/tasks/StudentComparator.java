package lesson3.tasks;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {

        String secondName1 = s1.getName().split("\\s", 2)[1];
        String secondName2 = s2.getName().split("\\s", 2)[1];

        return secondName1.compareTo(secondName2);
    }
}
