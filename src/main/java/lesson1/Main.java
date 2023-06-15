package lesson1;

public class Main {
    public static void main(String[] args) {
        B b = new B();
//        A a = new A();
        C c = new C();

//        a.bar();
        b.bar();
        c.bar();

//        a.foo();
        b.foo();
        c.foo();

        c.jump();
        c.jump(3);
        System.out.println(c.jump(5, 7));
    }
}
