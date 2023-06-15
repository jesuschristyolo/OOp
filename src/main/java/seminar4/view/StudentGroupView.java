package seminar4.view;

import seminar4.controller.SGController;
import seminar4.model.Student;
import seminar4.model.StudentGroup;
import seminar4.model.Teacher;

import java.util.List;

public class StudentGroupView {
    SGController sgController;

    public StudentGroupView(SGController sgController) {
        this.sgController = sgController;
    }

    public void sendOnConsole(String sortType) {
        List<StudentGroup> groups = switch (sortType) {
            case SortType.NONE -> sgController.getAllGroups();
            case SortType.ID -> sgController.getAllSortId();
            default -> null;
        };
        if (groups == null) {
            System.out.println("groups is null");
            return;
        }
        System.out.println("=====================");
        for (StudentGroup studentGroup : groups) {
            System.out.println(groups);
        }
        System.out.println("=====================");
    }
    public void create(Teacher teacher, List<Student> students, String faculty,Integer countOfStudent) {
        sgController.create(teacher,students,faculty,countOfStudent);
    }

    public void create1(String faculty){
        sgController.create1(faculty);
    }

    public void PrintGroup(Long idGroup){
        sgController.PrintGroup(idGroup);
    }
    public void PrintAllGroups(){
        sgController.PrintAllGroups();
    }
    public void addStudentInGroup(String fullname, String faculty) {
        sgController.addStudentInGroup(fullname,faculty);
    }
}