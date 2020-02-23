import java.io.Serializable;

/**
 * @program: arithmatictest
 * @description:
 * @author: LLS
 * @create: 2019-03-02 16:17
 **/
public class User implements Serializable {
    private String name;
    private String age;
    private String sex;
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
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void print(){
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("性别："+sex);
    }
}
