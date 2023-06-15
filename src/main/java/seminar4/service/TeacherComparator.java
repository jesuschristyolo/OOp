package seminar4.service;

import seminar4.model.Teacher;

import java.util.Comparator;

public class TeacherComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        String familyName1 = o1.getFullName().split("\\s+")[2];
        String familyName2 = o2.getFullName().split("\\s+")[2];

        return familyName1.compareTo(familyName2);
    }
}