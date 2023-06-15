package seminar4.controller;

import seminar4.model.Student;
import seminar4.model.StudentGroup;
import seminar4.model.Teacher;
import seminar4.service.StudentGroupService;
import seminar4.service.UserService;

import java.util.List;

public class SGController implements StudentGroupController<StudentGroup>{
    public StudentGroupService studentGroupService;

    public SGController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @Override
    public void create(Teacher teacher, List<Student> students, String faculty, Integer countOfStudent) {
        studentGroupService.create(teacher,students,faculty, countOfStudent);
    }

    @Override
    public List<StudentGroup> getAllGroups() {
        return studentGroupService.getAllGroups();
    }

    @Override
    public List<StudentGroup> getAllSortId() {
        return studentGroupService.getAllSortId();
    }

    @Override
    public void removeGroup(Long id) {
        studentGroupService.removeGroup(id);
    }
    public Teacher getTeacherOfGroup(Long idGroup) {
        return studentGroupService.getTeacherOfGroup(idGroup);
    }
    public String getGroupOfTeacher(String fullname) {
        return studentGroupService.getGroupOfTeacher(fullname);
    }

    public void getGroupOfStudent(String fullname) {
        studentGroupService.getGroupOfStudent(fullname);
    }

    public StudentGroup getGroup(Long idGroup) {
        return studentGroupService.getGroup(idGroup);
    }

    public void PrintGroup(Long idGroup){
        studentGroupService.PrintGroup(idGroup);
    }

    public void PrintAllGroups(){
        studentGroupService.PrintAllGroups();
    }
    public void addGroup(StudentGroup studentGroup){
        studentGroupService.addGroup(studentGroup);
    }
    public void addStudentInGroup(String fullname, String faculty){
        studentGroupService.addStudentInGroup(fullname,faculty);
    }

    public void create1(String faculty){
        studentGroupService.create1(faculty);
    }

}