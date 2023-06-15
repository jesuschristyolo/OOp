package seminar4.service;

import seminar4.model.Student;
import seminar4.model.Teacher;

import java.util.List;

public interface GroupService <StudentGroup>{
    void create(Teacher teacher, List<Student> students, String faculty,Integer countOfStudent);
    List<StudentGroup> getAllGroups();
    List<StudentGroup> getAllSortId();
    void removeGroup (Long id);
}