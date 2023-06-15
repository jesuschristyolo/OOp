package seminar4.service;

import seminar4.model.StudentGroup;

import java.util.Comparator;

public class StudentGroupComparatorFaculty implements Comparator<StudentGroup> {
    @Override
    public int compare(StudentGroup o1, StudentGroup o2) {
        return o1.getFaculty().compareTo(o2.getFaculty());
    }
}