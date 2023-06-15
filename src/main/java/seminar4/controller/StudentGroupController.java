package seminar4.controller;

import seminar4.model.Student;
import seminar4.model.StudentGroup;
import seminar4.model.Teacher;

import java.util.List;

public interface StudentGroupController <StudentGroup>{
    void create(Teacher teacher, List<Student> students, String faculty,Integer countOfStudent);
    List<StudentGroup> getAllGroups();
    List<StudentGroup> getAllSortId();
    void removeGroup(Long id);


}