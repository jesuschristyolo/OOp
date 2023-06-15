package lesson1;

public class B extends A {
    public void baz() {
        System.out.println("baz");
    }


    @Override
    public void bar() {
        System.out.println("Class B");
    }

    @Override
    public String toString() {
        return "B{}";
    }
}
