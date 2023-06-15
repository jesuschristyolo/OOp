package seminar4.repository;

import lombok.Getter;
import lombok.Setter;
import seminar4.model.Student;
import seminar4.model.StudentGroup;
import seminar4.model.Teacher;
import seminar4.model.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentGroupRepository {
    private final List<StudentGroup> studentGroups;
    private int limitOfStudents = 3;
    private int limitOfTeachers = 1;

    public StudentGroupRepository() {
        this.studentGroups = new ArrayList<>();
        ;
    }

    public List<StudentGroup> getAllGroups() {
        return studentGroups;
    }

    public Teacher getTeacherOfGroup(Long idGroup) {
        StudentGroup group = getGroup(idGroup);
        return group.getTeacher();
    }


    public String getGroupOfTeacher(String fullname) {
        for (StudentGroup group : studentGroups) {
            if (group.getTeacher().getFullName().contains(fullname)) {
                return String.format("Это преподаватель %s группы!", group.getIdStudentGroup());
            }
        }
        return String.format("Преподаватель еще НЕ распределен!");
    }


    public StudentGroup getGroup(Long idGroup) {
        for (StudentGroup group : studentGroups) {
            if (group.getIdStudentGroup().equals(idGroup)) {
                return group;
            }
        }
        System.out.println("Такой группы не существует!");
        return null;
    }

    public void PrintGroup(Long idGroup) {
        System.out.println("=======================");
        System.out.println("ГРУППА №" + idGroup);
        for (User user : getGroup(idGroup)) {
            if (user.getStatus().equals("Teacher")) {
                System.out.println("ПРЕПОДАВАТЕЛЬ: " + user.getId() + ". " + user.getFullName());
            } else {
                System.out.println("СТУДЕНТ: " + user.getId() + ". " + user.getFullName());
            }
        }
        System.out.println("=======================");
    }

    public void PrintAllGroups() {
        System.out.println("=======================");
        for (StudentGroup group : studentGroups) {
            System.out.printf("ГРУППА:" + group.getIdStudentGroup() + "." +
                    ", Кол-во студентов: " + group.getCount() +
                    ", Факультет: " + group.getFaculty());
            for (User user : group) {
                if (user.getStatus().equals("Teacher")) {
                    System.out.println(", Преподаватель: " + user.getId() + ". " + user.getFullName());
                }
            }
        }
        System.out.println("=======================");
    }


    public void addGroup(StudentGroup studentGroup) {
        studentGroups.add(studentGroup);
    }


    public void removeGroup(Long id) {
        for (StudentGroup group : studentGroups) {
            if (group.getIdStudentGroup().equals(id)) {
                studentGroups.remove(group);
                return;
            }
        }
    }

    public Long getMaxIdGroup() {
        Long maxId = 0L;
        for (StudentGroup studentGroup : studentGroups) {
            if (studentGroup.getIdStudentGroup() > maxId) {
                maxId = studentGroup.getIdStudentGroup();
            }
        }
        return maxId;
    }

}