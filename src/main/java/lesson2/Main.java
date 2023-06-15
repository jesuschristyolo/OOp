package lesson2;

import java.io.Serializable;
import java.lang.annotation.Target;


@SerializableAnnotation
public class Main implements Serializable, Cloneable {
    public static void main(String[] args) {
        TestInterface.staticMethod();
    }

    @Test
    public void test() {
    }
}
