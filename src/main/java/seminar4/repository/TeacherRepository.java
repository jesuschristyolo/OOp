package seminar4.repository;

import lombok.Getter;
import seminar4.model.Teacher;
import seminar4.model.User;

import java.util.ArrayList;
import java.util.List;
@Getter
public class TeacherRepository implements UserRepository<Teacher> {
    private List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void add(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void remove(String name) {
        for (Teacher teacher:teachers) {
            if (teacher.getFullName().equals(name)) {
                teachers.remove(teacher);
                return;
            }
        }
    }

    @Override
    public Long getMaxId() {
        Long maxId= 0L;
        for (Teacher teacher:teachers) {
            if (teacher.getId()>maxId){
                maxId=teacher.getId();
            }
        }
        return maxId;
    }
}