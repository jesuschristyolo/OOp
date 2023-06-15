package seminar4.service;

import seminar4.model.Student;
import seminar4.model.StudentGroup;
import seminar4.model.Teacher;
import seminar4.model.User;
import seminar4.repository.StudentGroupRepository;
import seminar4.repository.StudentRepository;
import seminar4.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentGroupService implements GroupService<StudentGroup> {
    private StudentGroupRepository studentGroupRepository;
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    public StudentGroupService(StudentGroupRepository studentGroupRepository, TeacherRepository teacherRepository,
                               StudentRepository studentRepository) {
        this.studentGroupRepository = studentGroupRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void create(Teacher teacher, List<Student> students, String faculty, Integer countOfStudent) {
        Long id = studentGroupRepository.getMaxIdGroup() + 1;
        List<User> group = new ArrayList<User>(students);
        group.add(teacher);

        StudentGroup studentGroup = new StudentGroup(id, group, faculty, countOfStudent, teacher, students);
        studentGroupRepository.addGroup(studentGroup);
    }


    public void create1(String faculty) {
        List<Student> studentListForGroup = new ArrayList<>();
        Teacher teacherForGroup = null;
        Integer countOfStudent = 0;
        for (Teacher teacher : teacherRepository.getTeachers()) {
            if (teacher.isDistribution() == false) {
                teacherForGroup = teacher;
                teacher.setDistribution(true);
                break;
            }
        }
        if (teacherForGroup == null) {
            System.out.println("Все преподаватели распределены, " +
                    "создайте нового и добавьте его в группу!");
        }
        for (Student student : studentRepository.getStudents()) {
            if (studentListForGroup.size() < studentGroupRepository.getLimitOfStudents()) {
                if (student.isDistribution() == false) {
                    studentListForGroup.add(student);
                    student.setDistribution(true);
                    countOfStudent++;
                }
            }
        }
        if (studentListForGroup.size() == 0) {
            System.out.println("Все студенты распределены по группам!Создайте новых и добавьте их в группы!");
        }
        create(teacherForGroup, studentListForGroup, faculty, countOfStudent);
    }


    @Override
    public List<StudentGroup> getAllGroups() {
        return studentGroupRepository.getAllGroups();
    }

    @Override
    public List<StudentGroup> getAllSortId() {
        List<StudentGroup> groups = studentGroupRepository.getAllGroups();
        Collections.sort(groups);
        return groups;
    }


    @Override
    public void removeGroup(Long id) {
        studentGroupRepository.removeGroup(id);
    }

    public Teacher getTeacherOfGroup(Long idGroup) {
        return studentGroupRepository.getTeacherOfGroup(idGroup);
    }

    public String getGroupOfTeacher(String fullname) {
        return studentGroupRepository.getGroupOfTeacher(fullname);
    }

    public void getGroupOfStudent(String fullname) {
        for (StudentGroup group : studentGroupRepository.getStudentGroups()) {
            for (User student : group.getGroup()) {
                if (student.getStatus() == "Student" && student.getFullName().contains(fullname)) {
                    System.out.println("Это студент " + group.getIdStudentGroup() + " группы!");
                }
            }
        }
    }

    public StudentGroup getGroup(Long idGroup) {
        return studentGroupRepository.getGroup(idGroup);
    }

    public void PrintGroup(Long idGroup) {
        studentGroupRepository.PrintGroup(idGroup);
    }

    public void PrintAllGroups() {
        studentGroupRepository.PrintAllGroups();
    }

    public void addGroup(StudentGroup studentGroup) {
        studentGroupRepository.addGroup(studentGroup);
    }

    public void addStudentInGroup(String fullname, String faculty) {
        for (Student student : studentRepository.getStudents()) {
            if (student.getFullName().contains(fullname)) {
                if (student.isDistribution() == true) {
                    System.out.println("Данный студент уже распределен!");
                    getGroupOfStudent(fullname);
                    break;
                } else {
                    for (StudentGroup group : studentGroupRepository.getAllGroups()) {
                        if (group.getFaculty().equals(faculty)) {
                            if (group.getStudents().size() < studentGroupRepository.getLimitOfStudents()) {
                                group.getStudents().add(student);
                                group.getGroup().add(student);
                                student.setDistribution(true);
                                System.out.println("Студент добавлен в " + group.getIdStudentGroup() + "группу!");
                                group.setCount(group.getCount()+1);
                                return;
                            } else {
                                System.out.println("Все группы заполнены, выберите другой факультет " +
                                        "или создайте новую группу!");
                            }
                        }
                    }
                }
            }
        }
    }
}