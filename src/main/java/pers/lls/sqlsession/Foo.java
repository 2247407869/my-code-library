package pers.lls.sqlsession;

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
