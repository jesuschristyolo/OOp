package lesson3.tasks;


public class StudentGroupController {
    private final StudentGroupService studentGroupService;

    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    public void deleteStudent(String name) {
        studentGroupService.removeStudentByName(name);
    }

    public void printAllStudents() {
        studentGroupService.printAllStudents();
    }

    public void sortStudents() {
        studentGroupService.sortStudents();
    }

    public void sortStudentsByFamilyName() {
        studentGroupService.sortStudentsByFamilyName();
    }
}
