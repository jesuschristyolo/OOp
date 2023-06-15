package lesson1;

public class C extends A implements InterfaceTest {
/*    public void foo() {
        System.out.println("SUPER NEW FOO!");
    }*/

    @Override
    public void bar() {
        System.out.println("Class C");
    }

    @Override
    public void run() {

    }

    @Override
    public void jump() {
        System.out.println("null");
    }

    public void jump(int x) {
        System.out.println(x);
    }

    public int jump(int x, int y) {
        return x + y;
    }
}
