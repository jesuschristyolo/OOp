package lesson3.tasks;

public class Main {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();
        group.addStudent(new Student(4L, "Ivan Morozov"));
        group.addStudent(new Student(6L, "Petr Vorobev"));
        group.addStudent(new Student(2L, "Sidor Sidorov"));
        group.addStudent(new Student(1L, "Elena Ivanova"));
        group.addStudent(new Student(8L, "Anna Morozova"));


/*
        GroupService groupService = new GroupService(group);
        GroupController controller = new GroupController(groupService);

        controller.printAllStudents();
        System.out.println("After sorting:");
        controller.sortStudents();
        controller.printAllStudents();
        System.out.println("After comparator-sorting");
        controller.sortStudentsByFamilyName();
        controller.printAllStudents();*/
    }
}
