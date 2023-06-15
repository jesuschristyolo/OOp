package lesson3;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(12L, "Иван");
        System.out.println(student.getFullName());

        System.out.println(student);

        List<Integer> list = List.of(1, 4, 6, 2, 8);

        for (Integer integer : list) {
            System.out.print(integer);
        }
        System.out.println();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }



    }
}
