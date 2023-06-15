package seminar4.view;

import seminar4.controller.UserController;
import seminar4.model.Student;
import seminar4.model.Teacher;

import java.util.List;
import java.util.Scanner;

public class TeacherView implements UserView<Teacher> {
    UserController<Teacher> controller;
    Scanner scanner = new Scanner(System.in);

    public TeacherView(UserController<Teacher> controller) {

        this.controller = controller;

    }



    @Override
    public void sendOnConsole(String sortType) {
        List<Teacher> teachers = switch (sortType) {
            case SortType.NONE -> controller.getAll();
            case SortType.NAME -> controller.getAllSortUsers();
            case SortType.FAMILY -> controller.getAllSortUsersByFamilyName();
            case SortType.AGE -> controller.getAllSortUsersByAge();
            default -> null;
        };
        if (teachers == null) {
            System.out.println("students is null");
            return;
        }
        System.out.println("=====================");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        System.out.println("=====================");
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber) {
        controller.create(fullName, age, phoneNumber);
    }
    public List<Teacher> getAll() {
        return controller.getAll();
    }
    @Override
    public void removeUser(String fullName) {
        controller.removeUser(fullName);
    }

    public void changeTeacherFio(Teacher newTeacher,String newFio) {
        newTeacher.setFullName(newFio);
        System.out.println("ФИО успешно изменены!");
    }

    public void changeTeacherAge(Teacher newTeacher,Integer newAge) {
        newTeacher.setAge(newAge);
        System.out.println("Возраст успешно изменен!");
    }
    public void changeTeacherPhoneNumber(Teacher newTeacher,String newPhone) {
        newTeacher.setPhoneNumber(newPhone);
        System.out.println("Телефон успешно изменен!");
    }

    public void changeTeacher() {
        System.out.println("Кого будем редактировать?(введите фамилию):\n");
        String changeFullname = this.scanner.nextLine();
        if (changeFullname == null) {return;}
        List<Teacher> teachers = controller.getAll();
        for (Teacher teacher : teachers) {
            if (teacher.getFullName().contains(changeFullname)) {
                Teacher newTeacher = teacher;
                System.out.println(teacher);
                System.out.println("Что будем редактировать?(введите цифру):\n" +
                        "1. ФИО\n" +
                        "2. Возраст\n" +
                        "3. Телефон\n");
                int choice = this.scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Введите НОВОЕ ФИО:");
                    String newFio = this.scanner.nextLine();
                    changeTeacherFio(newTeacher,newFio);
                }
                if (choice == 2) {
                    System.out.println("Введите НОВЫЙ возраст:");
                    Integer newAge = this.scanner.nextInt();
                    changeTeacherAge(newTeacher,newAge);
                }
                if (choice == 3) {
                    System.out.println("Введите НОВЫЙ телефон:");
                    Scanner scanner1 = new Scanner(System.in);
                    String newPhone = scanner1.nextLine();
                    changeTeacherPhoneNumber(newTeacher, newPhone);
                    scanner1.close();
                }

            }
        }

    }
}