package pers.lls.ioc;

public class Main {
    public static void main(String[] args) throws Exception {

        //加载配置文件
        BeanFactory f = new ClassPathXmlApplicationContext("applicationContext.xml");

        Object os = f.getBean("dog");
        Animal dog = (Animal)os;
        dog.say();

        Object op = f.getBean("chicken");
        Animal chicken = (Animal)op;
        chicken.say();

        Object p = f.getBean("people");
        People people= (People) p;
        people.info();
    }
}
