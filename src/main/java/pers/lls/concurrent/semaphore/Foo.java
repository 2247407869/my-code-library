package pers.lls.concurrent.semaphore;

/**
 * @program: helloworld
 * @description:
 * @author: lils
 * @create: 2019-07-02 17:56
 */
public class Foo {
    private String name;
    private String age;

    public Foo(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
