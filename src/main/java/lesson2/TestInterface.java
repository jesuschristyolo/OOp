package lesson2;

public interface TestInterface {
    public final String name = "NAME";
    void test();

    static void staticMethod() {
        System.out.println("Static method interface");
    }

    private void privateMethod() {
        System.out.println("Приватный метод интерфейса");
    }

    default void defaultMethod() {
        System.out.println("Базовая реализация метода интерфейса");
        privateMethod();
    }
}
