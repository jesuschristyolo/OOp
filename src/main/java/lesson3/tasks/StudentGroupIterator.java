package lesson3.tasks;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentGroupIterator implements Iterator<Student> {
    private int position;
    private final List<Student> students;

    public StudentGroupIterator(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return position < students.size();
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return students.get(position++);
    }

    @Override
    public void remove() {
        if (position <= 0){
            throw new IllegalStateException("No elements to remove on position " + position);
        }
        students.remove(--position);
    }
}
