package seminar4;

import seminar4.controller.SGController;
import seminar4.controller.StudentController;
import seminar4.controller.TeacherController;
import seminar4.model.Student;
import seminar4.model.StudentGroup;
import seminar4.repository.StudentGroupRepository;
import seminar4.repository.StudentRepository;
import seminar4.repository.TeacherRepository;
import seminar4.service.StudentGroupService;
import seminar4.service.StudentService;
import seminar4.service.TeacherService;
import seminar4.view.*;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        StudentService studentService = new StudentService(studentRepository);
        StudentController studentController = new StudentController(studentService);
        StudentView studentView=new StudentView(studentController);

        TeacherRepository teacherRepository = new TeacherRepository();
        TeacherService teacherService = new TeacherService(teacherRepository);
        TeacherController teacherController = new TeacherController(teacherService);
        TeacherView teacherView = new TeacherView(teacherController);

        StudentGroupRepository repository = new StudentGroupRepository();
        StudentGroupService service = new StudentGroupService(repository, teacherRepository,studentRepository
        );
        SGController controller = new SGController(service);
        StudentGroupView view = new StudentGroupView(controller);
//----------------------------------------------------------------------
        studentView.create("Ivan Morozov", 18, "02");
        studentView.create("Petr Vorobev", 19, "03");
        studentView.create("Sidor Sidorov", 20, "112");
        //view.sendOnConsole(SortType.NONE);
        studentView.create("Elena Ivanova", 19, "911");
        studentView.create("Anna Morozova", 17, "01");
        studentView.sendOnConsole(SortType.NONE);
        //view.sendOnConsole(SortType.NAME);
        //view.sendOnConsole(SortType.FAMILY);
        //view.sendOnConsole(SortType.AGE);

        teacherView.create("Mariya Ivanovna Solov'eva", 42, "452635");
        teacherView.create("Petr Semenovich Vorobev", 54, "54865");
        teacherView.create("Sidor Petrovich Sidorov", 29, "16212");
        teacherView.create("Elena Alekseevna Ivanova", 64, "9165241");
        teacherView.create("Anna Olegovna Morozova", 49, "016589");
        teacherView.sendOnConsole(SortType.NONE);
        //teacherView.sendOnConsole(SortType.NAME);
        //teacherView.sendOnConsole(SortType.FAMILY);
        //teacherView.sendOnConsole(SortType.AGE);
        //teacherView.changeTeacher();
        //teacherView.sendOnConsole(SortType.NONE);

        view.create1("Mathematics");
        view.PrintAllGroups();
        view.PrintGroup(1L);

        view.addStudentInGroup("Morozova","Mathematics");
        view.create1("economic");
        view.PrintAllGroups();
        view.PrintGroup(2L);
        view.addStudentInGroup("Morozova","economic");

        studentView.create("Sonya Kozlova", 19, "25963");
        studentView.sendOnConsole(SortType.NONE);
        view.addStudentInGroup("Kozlova", "economic");

        view.PrintAllGroups();
        view.PrintGroup(2L);

        view.sendOnConsole(SortType.ID);





    }

    private static StudentView getStudentView() {
        StudentRepository repository = new StudentRepository();
        StudentService service = new StudentService(repository);
        StudentController controller = new StudentController(service);
        return new StudentView(controller);
    }

    private static TeacherView getTeacherView() {
        TeacherRepository repository1 = new TeacherRepository();
        TeacherService service = new TeacherService(repository1);
        TeacherController controller = new TeacherController(service);
        return new TeacherView(controller);
    }



}